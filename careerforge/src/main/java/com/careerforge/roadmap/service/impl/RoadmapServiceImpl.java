package com.careerforge.roadmap.service.impl;

import com.careerforge.common.entity.Difficulty;
import com.careerforge.exception.BadRequestException;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.roadmap.dto.*;
import com.careerforge.roadmap.entity.*;
import com.careerforge.roadmap.mapper.QuestionMapper;
import com.careerforge.roadmap.mapper.RoadmapMapper;
import com.careerforge.roadmap.mapper.RoadmapSectionMapper;
import com.careerforge.roadmap.repository.*;
import com.careerforge.roadmap.service.RoadmapService;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class RoadmapServiceImpl implements RoadmapService {

    private final RoadmapRepository roadmapRepository;
    private final RoadmapSectionRepository roadmapSectionRepository;
    private final QuestionRepository questionRepository;
    private final QuestionLinkRepository questionLinkRepository;
    private final RoadmapSectionQuestionRepository roadmapSectionQuestionRepository;
    private final StudentRoadmapQuestionProgressRepository studentRoadmapQuestionProgressRepository;
    private final StudentProfileRepository studentProfileRepository;
    
    private final RoadmapMapper roadmapMapper;
    private final RoadmapSectionMapper roadmapSectionMapper;
    private final QuestionMapper questionMapper;

    public RoadmapServiceImpl(RoadmapRepository roadmapRepository,
                              RoadmapSectionRepository roadmapSectionRepository,
                              QuestionRepository questionRepository,
                              QuestionLinkRepository questionLinkRepository,
                              RoadmapSectionQuestionRepository roadmapSectionQuestionRepository,
                              StudentRoadmapQuestionProgressRepository studentRoadmapQuestionProgressRepository,
                              StudentProfileRepository studentProfileRepository,
                              RoadmapMapper roadmapMapper,
                              RoadmapSectionMapper roadmapSectionMapper,
                              QuestionMapper questionMapper) {
        this.roadmapRepository = roadmapRepository;
        this.roadmapSectionRepository = roadmapSectionRepository;
        this.questionRepository = questionRepository;
        this.questionLinkRepository = questionLinkRepository;
        this.roadmapSectionQuestionRepository = roadmapSectionQuestionRepository;
        this.studentRoadmapQuestionProgressRepository = studentRoadmapQuestionProgressRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.roadmapMapper = roadmapMapper;
        this.roadmapSectionMapper = roadmapSectionMapper;
        this.questionMapper = questionMapper;
    }

    // ======================== Roadmap CRUD ========================

    @Override
    public RoadmapDto createRoadmap(CreateRoadmapRequest request) {
        Roadmap roadmap = Roadmap.builder()
                .semester(request.getSemester())
                .monthsRemaining(request.getMonthsRemaining())
                .targetRoles(request.getTargetRoles())
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
        Roadmap saved = roadmapRepository.save(roadmap);
        log.info("Created new Roadmap with ID: {}", saved.getId());
        return roadmapMapper.toDto(saved);
    }

    @Override
    public RoadmapDto updateRoadmap(UUID id, UpdateRoadmapRequest request) {
        Roadmap roadmap = roadmapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + id));

        roadmap.setSemester(request.getSemester());
        roadmap.setMonthsRemaining(request.getMonthsRemaining());
        roadmap.setTargetRoles(request.getTargetRoles());
        roadmap.setTitle(request.getTitle());
        roadmap.setDescription(request.getDescription());

        Roadmap updated = roadmapRepository.save(roadmap);
        log.info("Updated Roadmap with ID: {}", updated.getId());
        return roadmapMapper.toDto(updated);
    }

    @Override
    public void deleteRoadmap(UUID id) {
        Roadmap roadmap = roadmapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + id));
        roadmapRepository.delete(roadmap);
        log.info("Deleted Roadmap with ID: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public RoadmapDto getRoadmapById(UUID id) {
        Roadmap roadmap = roadmapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + id));
        return roadmapMapper.toDto(roadmap);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RoadmapDto> getAllRoadmaps(Pageable pageable) {
        return roadmapRepository.findAll(pageable).map(roadmapMapper::toDto);
    }

    // ======================== RoadmapSection CRUD ========================

    @Override
    public RoadmapSectionTreeDto createSection(CreateRoadmapSectionRequest request) {
        Roadmap roadmap = roadmapRepository.findById(request.getRoadmapId())
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + request.getRoadmapId()));

        RoadmapSection parent = null;
        if (request.getParentId() != null) {
            parent = roadmapSectionRepository.findById(request.getParentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent section not found with ID: " + request.getParentId()));
            if (!parent.getRoadmap().getId().equals(roadmap.getId())) {
                throw new BadRequestException("Parent section must belong to the same roadmap.");
            }
        }

        // Shift existing siblings to avoid unique constraint violations
        shiftSiblingSections(roadmap.getId(), request.getParentId(), request.getPosition(), null);

        RoadmapSection section = RoadmapSection.builder()
                .roadmap(roadmap)
                .parentSection(parent)
                .parentId(request.getParentId())
                .title(request.getTitle())
                .position(request.getPosition())
                .build();

        RoadmapSection saved = roadmapSectionRepository.save(section);
        log.info("Created new RoadmapSection with ID: {}", saved.getId());
        return roadmapSectionMapper.toTreeDto(saved);
    }

    @Override
    public RoadmapSectionTreeDto updateSection(UUID id, UpdateRoadmapSectionRequest request) {
        RoadmapSection section = roadmapSectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Section not found with ID: " + id));

        RoadmapSection parent = null;
        if (request.getParentId() != null) {
            // Cycle detection
            RoadmapSection current = roadmapSectionRepository.findById(request.getParentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent section not found with ID: " + request.getParentId()));
            
            while (current != null) {
                if (current.getId().equals(id)) {
                    throw new BadRequestException("Cycle detected: Parent section cannot be a child of itself.");
                }
                current = current.getParentSection();
            }

            parent = roadmapSectionRepository.findById(request.getParentId()).get();
            if (!parent.getRoadmap().getId().equals(section.getRoadmap().getId())) {
                throw new BadRequestException("Parent section must belong to the same roadmap.");
            }
        }

        boolean parentChanged = !Objects.equals(
                section.getParentSection() != null ? section.getParentSection().getId() : null, 
                request.getParentId()
        );
        boolean positionChanged = !section.getPosition().equals(request.getPosition());

        if (parentChanged || positionChanged) {
            // Shift siblings in new parent placement
            shiftSiblingSections(section.getRoadmap().getId(), request.getParentId(), request.getPosition(), null);
        }

        section.setParentSection(parent);
        section.setParentId(request.getParentId());
        section.setTitle(request.getTitle());
        section.setPosition(request.getPosition());

        RoadmapSection updated = roadmapSectionRepository.save(section);
        log.info("Updated RoadmapSection with ID: {}", updated.getId());
        return roadmapSectionMapper.toTreeDto(updated);
    }

    @Override
    public void deleteSection(UUID id) {
        RoadmapSection section = roadmapSectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Section not found with ID: " + id));
        
        UUID parentId = section.getParentSection() != null ? section.getParentSection().getId() : null;
        int deletedPos = section.getPosition();
        UUID roadmapId = section.getRoadmap().getId();

        roadmapSectionRepository.delete(section);
        roadmapSectionRepository.flush(); // Ensure deletion cascade completes before shifting

        // Shift down siblings
        shiftDownSiblingSections(roadmapId, parentId, deletedPos);
        log.info("Deleted RoadmapSection with ID: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoadmapSectionTreeDto> getSectionsTreeByRoadmapId(UUID roadmapId) {
        if (!roadmapRepository.existsById(roadmapId)) {
            throw new ResourceNotFoundException("Roadmap not found with ID: " + roadmapId);
        }
        
        List<RoadmapSection> allSections = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmapId);
        List<RoadmapSectionQuestion> allQuestions = roadmapSectionQuestionRepository.findByRoadmapSectionRoadmapId(roadmapId);

        return buildTree(allSections, allQuestions, Collections.emptyMap());
    }

    // ======================== Question CRUD ========================

    @Override
    public QuestionDto createQuestion(CreateQuestionRequest request) {
        Difficulty diff;
        try {
            diff = Difficulty.valueOf(request.getDifficulty().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid difficulty level: " + request.getDifficulty());
        }

        Question question = Question.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .difficulty(diff)
                .build();

        Question saved = questionRepository.save(question);
        log.info("Created Question with ID: {}", saved.getId());
        return questionMapper.toDto(saved);
    }

    @Override
    public QuestionDto updateQuestion(UUID id, UpdateQuestionRequest request) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with ID: " + id));

        Difficulty diff;
        try {
            diff = Difficulty.valueOf(request.getDifficulty().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid difficulty level: " + request.getDifficulty());
        }

        question.setTitle(request.getTitle());
        question.setDescription(request.getDescription());
        question.setDifficulty(diff);

        Question updated = questionRepository.save(question);
        log.info("Updated Question with ID: {}", updated.getId());
        return questionMapper.toDto(updated);
    }

    @Override
    public void deleteQuestion(UUID id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with ID: " + id));
        // Restrict delete if mapped to any sections
        questionRepository.delete(question);
        log.info("Deleted Question with ID: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuestionDto> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList());
    }

    // ======================== QuestionLink CRUD ========================

    @Override
    public QuestionLinkDto createQuestionLink(UUID questionId, CreateQuestionLinkRequest request) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with ID: " + questionId));

        LinkType type;
        try {
            type = LinkType.valueOf(request.getLinkType().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid link type: " + request.getLinkType());
        }

        shiftQuestionLinks(questionId, request.getPosition());

        QuestionLink link = QuestionLink.builder()
                .question(question)
                .linkType(type)
                .label(request.getLabel())
                .url(request.getUrl())
                .position(request.getPosition())
                .build();

        QuestionLink saved = questionLinkRepository.save(link);
        log.info("Created QuestionLink with ID: {} for Question: {}", saved.getId(), questionId);
        return questionMapper.toLinkDto(saved);
    }

    @Override
    public QuestionLinkDto updateQuestionLink(UUID linkId, UpdateQuestionLinkRequest request) {
        QuestionLink link = questionLinkRepository.findById(linkId)
                .orElseThrow(() -> new ResourceNotFoundException("QuestionLink not found with ID: " + linkId));

        LinkType type;
        try {
            type = LinkType.valueOf(request.getLinkType().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid link type: " + request.getLinkType());
        }

        if (!link.getPosition().equals(request.getPosition())) {
            shiftQuestionLinks(link.getQuestion().getId(), request.getPosition());
        }

        link.setLinkType(type);
        link.setLabel(request.getLabel());
        link.setUrl(request.getUrl());
        link.setPosition(request.getPosition());

        QuestionLink updated = questionLinkRepository.save(link);
        return questionMapper.toLinkDto(updated);
    }

    @Override
    public void deleteQuestionLink(UUID linkId) {
        QuestionLink link = questionLinkRepository.findById(linkId)
                .orElseThrow(() -> new ResourceNotFoundException("QuestionLink not found with ID: " + linkId));
        
        UUID questionId = link.getQuestion().getId();
        int deletedPos = link.getPosition();

        questionLinkRepository.delete(link);
        questionLinkRepository.flush();

        // Shift down links
        List<QuestionLink> links = questionLinkRepository.findAll().stream()
                .filter(l -> l.getQuestion().getId().equals(questionId) && l.getPosition() > deletedPos)
                .sorted(Comparator.comparing(QuestionLink::getPosition))
                .collect(Collectors.toList());

        for (QuestionLink l : links) {
            l.setPosition(l.getPosition() - 1);
            questionLinkRepository.saveAndFlush(l);
        }
    }

    // ======================== RoadmapSectionQuestion Assignment ========================

    @Override
    public RoadmapSectionQuestionDto assignQuestionToSection(UUID sectionId, AssignQuestionRequest request) {
        RoadmapSection section = roadmapSectionRepository.findById(sectionId)
                .orElseThrow(() -> new ResourceNotFoundException("Section not found with ID: " + sectionId));

        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new ResourceNotFoundException("Question not found with ID: " + request.getQuestionId()));

        shiftSectionQuestions(sectionId, request.getPosition());

        RoadmapSectionQuestion rsq = RoadmapSectionQuestion.builder()
                .roadmapSection(section)
                .question(question)
                .position(request.getPosition())
                .build();

        RoadmapSectionQuestion saved = roadmapSectionQuestionRepository.save(rsq);
        log.info("Assigned Question: {} to Section: {} at position: {}", question.getId(), sectionId, request.getPosition());
        return questionMapper.toSectionQuestionDto(saved);
    }

    @Override
    public void removeQuestionFromSection(UUID sectionQuestionId) {
        RoadmapSectionQuestion rsq = roadmapSectionQuestionRepository.findById(sectionQuestionId)
                .orElseThrow(() -> new ResourceNotFoundException("RoadmapSectionQuestion mapping not found with ID: " + sectionQuestionId));
        
        UUID sectionId = rsq.getRoadmapSection().getId();
        int deletedPos = rsq.getPosition();

        roadmapSectionQuestionRepository.delete(rsq);
        roadmapSectionQuestionRepository.flush();

        // Shift down positions
        List<RoadmapSectionQuestion> questions = roadmapSectionQuestionRepository.findByRoadmapSectionIdOrderByPositionAsc(sectionId).stream()
                .filter(q -> q.getPosition() > deletedPos)
                .sorted(Comparator.comparing(RoadmapSectionQuestion::getPosition))
                .collect(Collectors.toList());

        for (RoadmapSectionQuestion q : questions) {
            q.setPosition(q.getPosition() - 1);
            roadmapSectionQuestionRepository.saveAndFlush(q);
        }
    }

    // ======================== Student Personalized Generation & Progress ========================

    @Override
    @Transactional(readOnly = true)
    public PersonalizedRoadmapResponse getPersonalizedRoadmap(UUID studentUserId, UUID roadmapId) {
        StudentProfile student = studentProfileRepository.findByUserId(studentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for user ID: " + studentUserId));

        if (roadmapId == null && (student.getSemester() == null || student.getTargetRole() == null)) {
            throw new IllegalArgumentException("Student profile is incomplete. Please set your semester and target role first.");
        }

        Roadmap roadmap;
        if (roadmapId != null) {
            roadmap = roadmapRepository.findById(roadmapId)
                    .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + roadmapId));
        } else {
            roadmap = roadmapRepository.findBySemesterAndTargetRole(
                    student.getSemester(),
                    student.getTargetRole().name()
            ).orElseThrow(() -> new ResourceNotFoundException(
                    String.format("No personalized roadmap found matching Semester: %d and Target Role: %s. Please contact the administrator.",
                            student.getSemester(), student.getTargetRole())
            ));
        }

        List<RoadmapSection> allSections = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmap.getId());
        List<RoadmapSectionQuestion> allQuestions = roadmapSectionQuestionRepository.findByRoadmapSectionRoadmapId(roadmap.getId());
        
        List<StudentRoadmapQuestionProgress> progressList = studentRoadmapQuestionProgressRepository.findByStudentId(student.getId());
        Map<UUID, StudentRoadmapQuestionProgress> progressMap = progressList.stream()
                .collect(Collectors.toMap(p -> p.getRoadmapSectionQuestion().getId(), p -> p));

        List<RoadmapSectionTreeDto> tree = buildTree(allSections, allQuestions, progressMap);

        return PersonalizedRoadmapResponse.builder()
                .roadmap(roadmapMapper.toDto(roadmap))
                .sections(tree)
                .build();
    }

    @Override
    public void updateStudentQuestionProgress(UUID studentUserId, UUID sectionQuestionId, UpdateStudentProgressRequest request) {
        StudentProfile student = studentProfileRepository.findByUserId(studentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for user ID: " + studentUserId));

        RoadmapSectionQuestion rsq = roadmapSectionQuestionRepository.findById(sectionQuestionId)
                .orElseThrow(() -> new ResourceNotFoundException("RoadmapSectionQuestion not found with ID: " + sectionQuestionId));

        // Placement Access Validation
        Roadmap roadmap = rsq.getRoadmapSection().getRoadmap();
        boolean hasAccess = roadmap.getSemester().equals(student.getSemester()) &&
                roadmap.getTargetRoles().contains(student.getTargetRole());
        
        if (!hasAccess) {
            throw new AccessDeniedException("You do not have permission to update progress for this roadmap placement.");
        }

        StudentRoadmapQuestionProgressId progressId = StudentRoadmapQuestionProgressId.builder()
                .studentId(student.getId())
                .roadmapSectionQuestionId(sectionQuestionId)
                .build();

        StudentRoadmapQuestionProgress progress = studentRoadmapQuestionProgressRepository.findById(progressId)
                .orElseGet(() -> StudentRoadmapQuestionProgress.builder()
                        .id(progressId)
                        .student(student)
                        .roadmapSectionQuestion(rsq)
                        .completed(false)
                        .revisionMarked(false)
                        .build());

        if (request.getCompleted() != null) {
            if (request.getCompleted() && !progress.isCompleted()) {
                progress.setCompletedAt(LocalDateTime.now());
            } else if (!request.getCompleted()) {
                progress.setCompletedAt(null);
            }
            progress.setCompleted(request.getCompleted());
        }

        if (request.getRevisionMarked() != null) {
            progress.setRevisionMarked(request.getRevisionMarked());
        }

        if (request.getNote() != null) {
            progress.setNote(request.getNote());
        }

        studentRoadmapQuestionProgressRepository.save(progress);
        log.info("Updated progress for student: {} on section question: {}", student.getId(), sectionQuestionId);
    }

    // ======================== Helper Methods ========================

    private void shiftSiblingSections(UUID roadmapId, UUID parentId, int targetPos, UUID excludeId) {
        List<RoadmapSection> siblings = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmapId).stream()
                .filter(s -> Objects.equals(s.getParentSection() != null ? s.getParentSection().getId() : null, parentId))
                .filter(s -> excludeId == null || !s.getId().equals(excludeId))
                .collect(Collectors.toList());

        List<RoadmapSection> toShift = siblings.stream()
                .filter(s -> s.getPosition() >= targetPos)
                .sorted(Comparator.comparing(RoadmapSection::getPosition).reversed())
                .collect(Collectors.toList());

        for (RoadmapSection s : toShift) {
            s.setPosition(s.getPosition() + 1);
            roadmapSectionRepository.saveAndFlush(s);
        }
    }

    private void shiftDownSiblingSections(UUID roadmapId, UUID parentId, int deletedPos) {
        List<RoadmapSection> siblings = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmapId).stream()
                .filter(s -> Objects.equals(s.getParentSection() != null ? s.getParentSection().getId() : null, parentId))
                .filter(s -> s.getPosition() > deletedPos)
                .sorted(Comparator.comparing(RoadmapSection::getPosition))
                .collect(Collectors.toList());

        for (RoadmapSection s : siblings) {
            s.setPosition(s.getPosition() - 1);
            roadmapSectionRepository.saveAndFlush(s);
        }
    }

    private void shiftQuestionLinks(UUID questionId, int targetPos) {
        List<QuestionLink> links = questionLinkRepository.findAll().stream()
                .filter(l -> l.getQuestion().getId().equals(questionId) && l.getPosition() >= targetPos)
                .sorted(Comparator.comparing(QuestionLink::getPosition).reversed())
                .collect(Collectors.toList());

        for (QuestionLink l : links) {
            l.setPosition(l.getPosition() + 1);
            questionLinkRepository.saveAndFlush(l);
        }
    }

    private void shiftSectionQuestions(UUID sectionId, int targetPos) {
        List<RoadmapSectionQuestion> questions = roadmapSectionQuestionRepository.findByRoadmapSectionIdOrderByPositionAsc(sectionId).stream()
                .filter(q -> q.getPosition() >= targetPos)
                .sorted(Comparator.comparing(RoadmapSectionQuestion::getPosition).reversed())
                .collect(Collectors.toList());

        for (RoadmapSectionQuestion q : questions) {
            q.setPosition(q.getPosition() + 1);
            roadmapSectionQuestionRepository.saveAndFlush(q);
        }
    }

    private List<RoadmapSectionTreeDto> buildTree(List<RoadmapSection> allSections, 
                                                 List<RoadmapSectionQuestion> allQuestions,
                                                 Map<UUID, StudentRoadmapQuestionProgress> progressMap) {
        
        Map<UUID, List<RoadmapSection>> parentMap = allSections.stream()
                .filter(s -> s.getParentId() != null)
                .collect(Collectors.groupingBy(RoadmapSection::getParentId));

        Map<UUID, List<RoadmapSectionQuestion>> questionsMap = allQuestions.stream()
                .collect(Collectors.groupingBy(q -> q.getRoadmapSection().getId()));

        List<RoadmapSection> rootSections = allSections.stream()
                .filter(s -> s.getParentId() == null)
                .collect(Collectors.toList());

        return rootSections.stream()
                .map(s -> assembleNode(s, parentMap, questionsMap, progressMap))
                .collect(Collectors.toList());
    }

    private RoadmapSectionTreeDto assembleNode(RoadmapSection section,
                                                Map<UUID, List<RoadmapSection>> parentMap,
                                                Map<UUID, List<RoadmapSectionQuestion>> questionsMap,
                                                Map<UUID, StudentRoadmapQuestionProgress> progressMap) {
        
        RoadmapSectionTreeDto dto = roadmapSectionMapper.toTreeDto(section);

        // Map children
        List<RoadmapSection> children = parentMap.getOrDefault(section.getId(), Collections.emptyList());
        dto.setChildren(children.stream()
                .map(c -> assembleNode(c, parentMap, questionsMap, progressMap))
                .collect(Collectors.toList()));

        // Map placed questions
        List<RoadmapSectionQuestion> questions = questionsMap.getOrDefault(section.getId(), Collections.emptyList());
        dto.setQuestions(questions.stream()
                .map(q -> {
                    RoadmapSectionQuestionDto qDto = questionMapper.toSectionQuestionDto(q);
                    
                    // Populate student context if available
                    StudentRoadmapQuestionProgress progress = progressMap.get(q.getId());
                    if (progress != null) {
                        qDto.setCompleted(progress.isCompleted());
                        qDto.setRevisionMarked(progress.isRevisionMarked());
                        qDto.setNote(progress.getNote());
                    } else if (!progressMap.isEmpty()) {
                        qDto.setCompleted(false);
                        qDto.setRevisionMarked(false);
                        qDto.setNote("");
                    }
                    
                    return qDto;
                })
                .sorted(Comparator.comparing(RoadmapSectionQuestionDto::getPosition))
                .collect(Collectors.toList()));

        return dto;
    }

    @Override
    public void seedDsaRoadmap(UUID roadmapId) {
        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + roadmapId));

        // Clear existing sections first to prevent constraints violations
        List<RoadmapSection> existing = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmapId);
        roadmapSectionRepository.deleteAll(existing);
        roadmapSectionRepository.flush();

        // Delegate to the comprehensive A2ZDsaSeeder
        com.careerforge.roadmap.seeder.A2ZDsaSeeder.seed(
                roadmap,
                roadmapSectionRepository,
                questionRepository,
                questionLinkRepository,
                roadmapSectionQuestionRepository
        );
    }

    @Override
    public void seedSpringBootRoadmap(UUID roadmapId) {
        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + roadmapId));

        // Clear existing sections first to prevent constraints violations
        List<RoadmapSection> existing = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmapId);
        roadmapSectionRepository.deleteAll(existing);
        roadmapSectionRepository.flush();

        // Delegate to the comprehensive SpringBootPrepSeeder
        com.careerforge.roadmap.seeder.SpringBootPrepSeeder.seed(
                roadmap,
                roadmapSectionRepository,
                questionRepository,
                questionLinkRepository,
                roadmapSectionQuestionRepository
        );
    }

    @Override
    public void seedMernRoadmap(UUID roadmapId) {
        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + roadmapId));

        // Clear existing sections first to prevent constraint violations
        List<RoadmapSection> existing = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmapId);
        roadmapSectionRepository.deleteAll(existing);
        roadmapSectionRepository.flush();

        // Delegate to the comprehensive MernPrepSeeder
        com.careerforge.roadmap.seeder.MernPrepSeeder.seed(
                roadmap,
                roadmapSectionRepository,
                questionRepository,
                questionLinkRepository,
                roadmapSectionQuestionRepository
        );
    }

    @Override
    public void seedFastApiRoadmap(UUID roadmapId) {
        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + roadmapId));

        // Clear existing sections first to prevent constraint violations
        List<RoadmapSection> existing = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmapId);
        roadmapSectionRepository.deleteAll(existing);
        roadmapSectionRepository.flush();

        // Delegate to the comprehensive FastApiPrepSeeder
        com.careerforge.roadmap.seeder.FastApiPrepSeeder.seed(
                roadmap,
                roadmapSectionRepository,
                questionRepository,
                questionLinkRepository,
                roadmapSectionQuestionRepository
        );
    }

    @Override
    public void seedFrontendRoadmap(UUID roadmapId) {
        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + roadmapId));

        // Clear existing sections first to prevent constraint violations
        List<RoadmapSection> existing = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmapId);
        roadmapSectionRepository.deleteAll(existing);
        roadmapSectionRepository.flush();

        // Delegate to the comprehensive FrontendPrepSeeder
        com.careerforge.roadmap.seeder.FrontendPrepSeeder.seed(
                roadmap,
                roadmapSectionRepository,
                questionRepository,
                questionLinkRepository,
                roadmapSectionQuestionRepository
        );
    }

    @Override
    public void seedAiMlRoadmap(UUID roadmapId) {
        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + roadmapId));

        // Clear existing sections first to prevent constraint violations
        List<RoadmapSection> existing = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmapId);
        roadmapSectionRepository.deleteAll(existing);
        roadmapSectionRepository.flush();

        // Delegate to the comprehensive AiMlPrepSeeder
        com.careerforge.roadmap.seeder.AiMlPrepSeeder.seed(
                roadmap,
                roadmapSectionRepository,
                questionRepository,
                questionLinkRepository,
                roadmapSectionQuestionRepository
        );
    }

    @Override
    public void seedDataScientistRoadmap(UUID roadmapId) {
        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + roadmapId));

        // Clear existing sections first to prevent constraint violations
        List<RoadmapSection> existing = roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmapId);
        roadmapSectionRepository.deleteAll(existing);
        roadmapSectionRepository.flush();

        // Delegate to the comprehensive DataScientistPrepSeeder
        com.careerforge.roadmap.seeder.DataScientistPrepSeeder.seed(
                roadmap,
                roadmapSectionRepository,
                questionRepository,
                questionLinkRepository,
                roadmapSectionQuestionRepository
        );
    }
}
