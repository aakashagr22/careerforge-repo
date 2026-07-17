package com.careerforge.notification.service;

import com.careerforge.notification.dto.NotificationDto;
import com.careerforge.student.entity.StudentProfile;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    List<NotificationDto> getStudentNotifications(UUID studentUserId);
    void markAsRead(UUID studentUserId, UUID notificationId);
    void createNotification(StudentProfile student, String message);
}
