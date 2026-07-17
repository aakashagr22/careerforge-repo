package com.careerforge.sheet.service.impl;

import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.sheet.dto.*;
import com.careerforge.sheet.entity.Sheet;
import com.careerforge.sheet.entity.SheetTopic;
import com.careerforge.sheet.entity.StudentSheetProgress;
import com.careerforge.sheet.mapper.SheetMapper;
import com.careerforge.sheet.mapper.SheetTopicMapper;
import com.careerforge.sheet.repository.SheetRepository;
import com.careerforge.sheet.repository.SheetTopicRepository;
import com.careerforge.sheet.repository.StudentSheetProgressRepository;
import com.careerforge.sheet.service.SheetService;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class SheetServiceImpl implements SheetService {

    private final SheetRepository sheetRepository;
    private final SheetTopicRepository sheetTopicRepository;
    private final StudentSheetProgressRepository progressRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final com.careerforge.progress.service.ProgressService progressService;
    private final org.springframework.context.ApplicationEventPublisher eventPublisher;
    private final SheetMapper sheetMapper;
    private final SheetTopicMapper sheetTopicMapper;

    public SheetServiceImpl(SheetRepository sheetRepository,
                            SheetTopicRepository sheetTopicRepository,
                            StudentSheetProgressRepository progressRepository,
                            StudentProfileRepository studentProfileRepository,
                            com.careerforge.progress.service.ProgressService progressService,
                            org.springframework.context.ApplicationEventPublisher eventPublisher,
                            SheetMapper sheetMapper,
                            SheetTopicMapper sheetTopicMapper) {
        this.sheetRepository = sheetRepository;
        this.sheetTopicRepository = sheetTopicRepository;
        this.progressRepository = progressRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.progressService = progressService;
        this.eventPublisher = eventPublisher;
        this.sheetMapper = sheetMapper;
        this.sheetTopicMapper = sheetTopicMapper;
    }

    // ======================== Sheet CRUD ========================

    @Override
    public SheetDto createSheet(CreateSheetRequest request) {
        Sheet sheet = Sheet.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .category(request.getCategory())
                .build();
        Sheet saved = sheetRepository.save(sheet);
        log.info("Created new Sheet with ID: {}", saved.getId());
        return sheetMapper.toDto(saved);
    }

    @Override
    public SheetDto updateSheet(UUID id, UpdateSheetRequest request) {
        Sheet sheet = sheetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sheet not found with ID: " + id));
        sheet.setTitle(request.getTitle());
        sheet.setDescription(request.getDescription());
        sheet.setCategory(request.getCategory());
        Sheet updated = sheetRepository.save(sheet);
        log.info("Updated Sheet with ID: {}", updated.getId());
        return sheetMapper.toDto(updated);
    }

    @Override
    public void deleteSheet(UUID id) {
        Sheet sheet = sheetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sheet not found with ID: " + id));
        sheetRepository.delete(sheet);
        log.info("Deleted Sheet with ID: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public SheetDto getSheetById(UUID id) {
        Sheet sheet = sheetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sheet not found with ID: " + id));
        return sheetMapper.toDto(sheet);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SheetDto> getAllSheets(Pageable pageable) {
        return sheetRepository.findAll(pageable).map(sheetMapper::toDto);
    }

    // ======================== SheetTopic CRUD ========================

    @Override
    public SheetTopicDto createSheetTopic(CreateSheetTopicRequest request) {
        Sheet sheet = sheetRepository.findById(request.getSheetId())
                .orElseThrow(() -> new ResourceNotFoundException("Sheet not found with ID: " + request.getSheetId()));

        SheetTopic topic = SheetTopic.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .difficulty(request.getDifficulty())
                .orderIndex(request.getOrderIndex())
                .sheet(sheet)
                .build();

        SheetTopic saved = sheetTopicRepository.save(topic);
        log.info("Created new SheetTopic with ID: {} for Sheet: {}", saved.getId(), sheet.getId());
        return sheetTopicMapper.toDto(saved);
    }

    @Override
    public SheetTopicDto updateSheetTopic(UUID id, UpdateSheetTopicRequest request) {
        SheetTopic topic = sheetTopicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SheetTopic not found with ID: " + id));

        topic.setTitle(request.getTitle());
        topic.setDescription(request.getDescription());
        topic.setDifficulty(request.getDifficulty());
        topic.setOrderIndex(request.getOrderIndex());

        SheetTopic updated = sheetTopicRepository.save(topic);
        log.info("Updated SheetTopic with ID: {}", updated.getId());
        return sheetTopicMapper.toDto(updated);
    }

    @Override
    public void deleteSheetTopic(UUID id) {
        SheetTopic topic = sheetTopicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SheetTopic not found with ID: " + id));
        sheetTopicRepository.delete(topic);
        log.info("Deleted SheetTopic with ID: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public SheetTopicDto getSheetTopicById(UUID id) {
        SheetTopic topic = sheetTopicRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SheetTopic not found with ID: " + id));
        return sheetTopicMapper.toDto(topic);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SheetTopicDto> getTopicsBySheetId(UUID sheetId) {
        if (!sheetRepository.existsById(sheetId)) {
            throw new ResourceNotFoundException("Sheet not found with ID: " + sheetId);
        }
        return sheetTopicRepository.findBySheetIdOrderByOrderIndexAsc(sheetId)
                .stream()
                .map(sheetTopicMapper::toDto)
                .collect(Collectors.toList());
    }

    // ======================== Student Progress ========================

    @Override
    public StudentSheetProgressDto markTopicCompleted(UUID studentUserId, UUID topicId, boolean completed) {
        StudentProfile student = studentProfileRepository.findByUserId(studentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for user ID: " + studentUserId));

        SheetTopic topic = sheetTopicRepository.findById(topicId)
                .orElseThrow(() -> new ResourceNotFoundException("SheetTopic not found with ID: " + topicId));

        StudentSheetProgress progress = progressRepository.findByStudentIdAndSheetTopicId(student.getId(), topicId)
                .orElse(null);

        if (progress == null) {
            progress = StudentSheetProgress.builder()
                    .student(student)
                    .sheetTopic(topic)
                    .completed(completed)
                    .completedAt(completed ? LocalDateTime.now() : null)
                    .build();
        } else {
            progress.setCompleted(completed);
            progress.setCompletedAt(completed ? LocalDateTime.now() : null);
        }

        StudentSheetProgress savedProgress = progressRepository.save(progress);
        log.info("Marked SheetTopic: {} as completed: {} for Student: {}", topicId, completed, student.getId());

        if (completed) {
            progressService.updateActivityAndStreak(studentUserId);
            eventPublisher.publishEvent(new com.careerforge.notification.event.NotificationEvent(
                    this,
                    student,
                    "Congratulations! You completed the topic: " + topic.getTitle() + ". Keep up the momentum!"
            ));
        }

        return StudentSheetProgressDto.builder()
                .id(savedProgress.getId())
                .studentId(student.getId())
                .sheetTopicId(topicId)
                .completed(savedProgress.isCompleted())
                .completedAt(savedProgress.getCompletedAt())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public double getProgressPercentage(UUID studentUserId, UUID sheetId) {
        StudentProfile student = studentProfileRepository.findByUserId(studentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for user ID: " + studentUserId));

        long totalTopics = sheetTopicRepository.countBySheetId(sheetId);
        if (totalTopics == 0) {
            return 0.0;
        }

        long completedTopics = progressRepository.countCompletedByStudentIdAndSheetId(student.getId(), sheetId);
        return ((double) completedTopics / totalTopics) * 100.0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UUID> getCompletedTopicIds(UUID studentUserId) {
        StudentProfile student = studentProfileRepository.findByUserId(studentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for user ID: " + studentUserId));
        return progressRepository.findAllByStudentId(student.getId())
                .stream()
                .filter(StudentSheetProgress::isCompleted)
                .map(p -> p.getSheetTopic().getId())
                .collect(Collectors.toList());
    }
}
