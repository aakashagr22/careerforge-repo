package com.careerforge.roadmap.service.impl;

import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.roadmap.dto.*;
import com.careerforge.roadmap.entity.Roadmap;
import com.careerforge.roadmap.entity.RoadmapPhase;
import com.careerforge.roadmap.mapper.RoadmapMapper;
import com.careerforge.roadmap.mapper.RoadmapPhaseMapper;
import com.careerforge.roadmap.repository.RoadmapPhaseRepository;
import com.careerforge.roadmap.repository.RoadmapRepository;
import com.careerforge.roadmap.service.RoadmapService;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class RoadmapServiceImpl implements RoadmapService {

    private final RoadmapRepository roadmapRepository;
    private final RoadmapPhaseRepository roadmapPhaseRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final RoadmapMapper roadmapMapper;
    private final RoadmapPhaseMapper roadmapPhaseMapper;

    public RoadmapServiceImpl(RoadmapRepository roadmapRepository,
                              RoadmapPhaseRepository roadmapPhaseRepository,
                              StudentProfileRepository studentProfileRepository,
                              RoadmapMapper roadmapMapper,
                              RoadmapPhaseMapper roadmapPhaseMapper) {
        this.roadmapRepository = roadmapRepository;
        this.roadmapPhaseRepository = roadmapPhaseRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.roadmapMapper = roadmapMapper;
        this.roadmapPhaseMapper = roadmapPhaseMapper;
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

    // ======================== RoadmapPhase CRUD ========================

    @Override
    public RoadmapPhaseDto createRoadmapPhase(CreateRoadmapPhaseRequest request) {
        Roadmap roadmap = roadmapRepository.findById(request.getRoadmapId())
                .orElseThrow(() -> new ResourceNotFoundException("Roadmap not found with ID: " + request.getRoadmapId()));

        RoadmapPhase phase = RoadmapPhase.builder()
                .roadmap(roadmap)
                .title(request.getTitle())
                .description(request.getDescription())
                .startMonth(request.getStartMonth())
                .endMonth(request.getEndMonth())
                .priority(request.getPriority())
                .build();

        RoadmapPhase saved = roadmapPhaseRepository.save(phase);
        log.info("Created new RoadmapPhase with ID: {} for Roadmap: {}", saved.getId(), roadmap.getId());
        return roadmapPhaseMapper.toDto(saved);
    }

    @Override
    public RoadmapPhaseDto updateRoadmapPhase(UUID id, UpdateRoadmapPhaseRequest request) {
        RoadmapPhase phase = roadmapPhaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RoadmapPhase not found with ID: " + id));

        phase.setTitle(request.getTitle());
        phase.setDescription(request.getDescription());
        phase.setStartMonth(request.getStartMonth());
        phase.setEndMonth(request.getEndMonth());
        phase.setPriority(request.getPriority());

        RoadmapPhase updated = roadmapPhaseRepository.save(phase);
        log.info("Updated RoadmapPhase with ID: {}", updated.getId());
        return roadmapPhaseMapper.toDto(updated);
    }

    @Override
    public void deleteRoadmapPhase(UUID id) {
        RoadmapPhase phase = roadmapPhaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RoadmapPhase not found with ID: " + id));
        roadmapPhaseRepository.delete(phase);
        log.info("Deleted RoadmapPhase with ID: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public RoadmapPhaseDto getRoadmapPhaseById(UUID id) {
        RoadmapPhase phase = roadmapPhaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RoadmapPhase not found with ID: " + id));
        return roadmapPhaseMapper.toDto(phase);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoadmapPhaseDto> getPhasesByRoadmapId(UUID roadmapId) {
        if (!roadmapRepository.existsById(roadmapId)) {
            throw new ResourceNotFoundException("Roadmap not found with ID: " + roadmapId);
        }
        return roadmapPhaseRepository.findByRoadmapIdOrderByPriorityAsc(roadmapId)
                .stream()
                .map(roadmapPhaseMapper::toDto)
                .collect(Collectors.toList());
    }

    // ======================== Student personalized generation ========================

    @Override
    @Transactional(readOnly = true)
    public PersonalizedRoadmapResponse getPersonalizedRoadmap(UUID studentUserId) {
        StudentProfile student = studentProfileRepository.findByUserId(studentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for user ID: " + studentUserId));

        if (student.getSemester() == null || student.getTargetRole() == null) {
            throw new IllegalArgumentException("Student profile is incomplete. Please set your semester and target role first.");
        }
        Roadmap roadmap = roadmapRepository.findBySemesterAndTargetRole(
                student.getSemester(),
                student.getTargetRole().name()
        ).orElseThrow(() -> new ResourceNotFoundException(
                String.format("No personalized roadmap found matching Semester: %d and Target Role: %s. Please contact the administrator.",
                        student.getSemester(), student.getTargetRole())
        ));

        List<RoadmapPhase> phases = roadmapPhaseRepository.findByRoadmapIdOrderByPriorityAsc(roadmap.getId());
        List<RoadmapPhaseDto> phaseDtos = phases.stream()
                .map(roadmapPhaseMapper::toDto)
                .collect(Collectors.toCollection(ArrayList::new));

        // If communication track is enabled, append soft-skills phase
        if (student.isCommunicationTrackEnabled()) {
            log.info("Student profile has communication track enabled. Appending default Soft-Skills Phase.");
            RoadmapPhaseDto commPhase = RoadmapPhaseDto.builder()
                    .id(UUID.randomUUID())
                    .roadmapId(roadmap.getId())
                    .title("Communication & Interview Skills")
                    .description("Focus on mock interviews, public speaking, resumes building, and behavioral HR rounds practice.")
                    .startMonth(1)
                    .endMonth(roadmap.getMonthsRemaining())
                    .priority(100) // ensure it's at the end
                    .build();
            phaseDtos.add(commPhase);
        }

        return PersonalizedRoadmapResponse.builder()
                .roadmap(roadmapMapper.toDto(roadmap))
                .phases(phaseDtos)
                .build();
    }
}
