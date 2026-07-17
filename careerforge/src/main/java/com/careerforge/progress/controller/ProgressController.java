package com.careerforge.progress.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.progress.dto.DashboardResponseDto;
import com.careerforge.progress.service.ProgressService;
import com.careerforge.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Student Dashboard & Progress", description = "APIs for tracking student progress metrics, streaks and activity logs")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("/api/student/dashboard")
    @Operation(summary = "Get student dashboard progress statistics (Student)")
    public ResponseEntity<ApiResponse<DashboardResponseDto>> getDashboard(
            @AuthenticationPrincipal UserPrincipal principal) {
        DashboardResponseDto dashboard = progressService.getStudentDashboard(principal.getId());
        return ResponseEntity.ok(ApiResponse.success(dashboard, "Student dashboard data retrieved successfully"));
    }
}
