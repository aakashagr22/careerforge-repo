package com.careerforge.notification.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.notification.dto.NotificationDto;
import com.careerforge.notification.service.NotificationService;
import com.careerforge.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Student Notifications", description = "APIs for student notification feeds and alert reads")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/api/student/notifications")
    @Operation(summary = "Get list of all notifications (Student)")
    public ResponseEntity<ApiResponse<List<NotificationDto>>> getNotifications(
            @AuthenticationPrincipal UserPrincipal principal) {
        List<NotificationDto> notifications = notificationService.getStudentNotifications(principal.getId());
        return ResponseEntity.ok(ApiResponse.success(notifications, "Student notifications retrieved successfully"));
    }

    @PutMapping("/api/student/notifications/{id}/read")
    @Operation(summary = "Mark a notification as read (Student)")
    public ResponseEntity<ApiResponse<Void>> markAsRead(
            @PathVariable UUID id,
            @AuthenticationPrincipal UserPrincipal principal) {
        notificationService.markAsRead(principal.getId(), id);
        return ResponseEntity.ok(ApiResponse.success("Notification marked as read"));
    }
}
