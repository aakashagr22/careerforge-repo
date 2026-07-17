package com.careerforge.notification;

import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.notification.dto.NotificationDto;
import com.careerforge.notification.entity.Notification;
import com.careerforge.notification.mapper.NotificationMapper;
import com.careerforge.notification.repository.NotificationRepository;
import com.careerforge.notification.service.impl.NotificationServiceImpl;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.access.AccessDeniedException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    @Mock
    private NotificationRepository notificationRepository;

    @Mock
    private NotificationMapper notificationMapper;

    @InjectMocks
    private NotificationServiceImpl notificationService;

    private UUID userId;
    private StudentProfile student;
    private Notification notification;
    private NotificationDto notificationDto;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
        UUID studentId = UUID.randomUUID();

        student = StudentProfile.builder()
                .id(studentId)
                .user(User.builder().id(userId).build())
                .streak(0)
                .build();

        notification = Notification.builder()
                .id(UUID.randomUUID())
                .student(student)
                .message("Test notification")
                .read(false)
                .build();

        notificationDto = NotificationDto.builder()
                .id(notification.getId())
                .studentId(studentId)
                .message("Test notification")
                .read(false)
                .build();
    }

    @Test
    void getStudentNotifications_ShouldReturnList() {
        when(notificationRepository.findByStudentUserIdOrderByCreatedAtDesc(userId)).thenReturn(List.of(notification));
        when(notificationMapper.toDto(notification)).thenReturn(notificationDto);

        List<NotificationDto> result = notificationService.getStudentNotifications(userId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test notification", result.get(0).getMessage());
    }

    @Test
    void markAsRead_ShouldUpdateStatus_WhenAuthorized() {
        when(notificationRepository.findById(notification.getId())).thenReturn(Optional.of(notification));
        when(notificationRepository.save(any(Notification.class))).thenReturn(notification);

        assertDoesNotThrow(() -> notificationService.markAsRead(userId, notification.getId()));

        assertTrue(notification.isRead());
        verify(notificationRepository, times(1)).save(notification);
    }

    @Test
    void markAsRead_ShouldThrowAccessDenied_WhenUnauthorized() {
        UUID unauthorizedUserId = UUID.randomUUID();
        when(notificationRepository.findById(notification.getId())).thenReturn(Optional.of(notification));

        assertThrows(AccessDeniedException.class, () -> notificationService.markAsRead(unauthorizedUserId, notification.getId()));
        verify(notificationRepository, never()).save(any(Notification.class));
    }

    @Test
    void markAsRead_ShouldThrowNotFound_WhenNotExists() {
        UUID unknownId = UUID.randomUUID();
        when(notificationRepository.findById(unknownId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> notificationService.markAsRead(userId, unknownId));
    }

    @Test
    void createNotification_ShouldSaveNotification() {
        when(notificationRepository.save(any(Notification.class))).thenReturn(notification);

        assertDoesNotThrow(() -> notificationService.createNotification(student, "New event logged"));

        verify(notificationRepository, times(1)).save(any(Notification.class));
    }
}
