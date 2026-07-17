package com.careerforge.analytics.controller;

import com.careerforge.analytics.dto.AdminDashboardStatsDto;
import com.careerforge.analytics.service.AnalyticsService;
import com.careerforge.common.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Analytics (Admin)", description = "APIs for platform usage analytics and statistics dashboards")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/api/admin/dashboard/stats")
    @Operation(summary = "Get admin dashboard statistics (Admin)")
    public ResponseEntity<ApiResponse<AdminDashboardStatsDto>> getAdminStats() {
        AdminDashboardStatsDto stats = analyticsService.getAdminDashboardStats();
        return ResponseEntity.ok(ApiResponse.success(stats, "Admin dashboard statistics retrieved successfully"));
    }
}
