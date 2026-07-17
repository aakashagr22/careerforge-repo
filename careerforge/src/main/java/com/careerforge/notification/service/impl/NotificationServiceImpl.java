package com.careerforge.notification.service.impl;

import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.notification.dto.NotificationDto;
import com.careerforge.notification.entity.Notification;
import com.careerforge.notification.mapper.NotificationMapper;
import com.careerforge.notification.repository.NotificationRepository;
import com.careerforge.notification.service.NotificationService;
import com.careerforge.student.entity.StudentProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public NotificationServiceImpl(NotificationRepository notificationRepository,
                                   NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificationDto> getStudentNotifications(UUID studentUserId) {
        return notificationRepository.findByStudentUserIdOrderByCreatedAtDesc(studentUserId)
                .stream()
                .map(notificationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void markAsRead(UUID studentUserId, UUID notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with ID: " + notificationId));

        if (!notification.getStudent().getUser().getId().equals(studentUserId)) {
            throw new AccessDeniedException("You are not authorized to access this notification.");
        }

        notification.setRead(true);
        notificationRepository.save(notification);
        log.info("Marked notification: {} as read for student user: {}", notificationId, studentUserId);
    }

    @Override
    public void createNotification(StudentProfile student, String message) {
        Notification notification = Notification.builder()
                .student(student)
                .message(message)
                .read(false)
                .build();
        notificationRepository.save(notification);
        log.info("Created notification for student ID: {}. Message: {}", student.getId(), message);
    }
}
