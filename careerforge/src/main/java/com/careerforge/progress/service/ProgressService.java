package com.careerforge.progress.service;

import com.careerforge.progress.dto.DashboardResponseDto;

import java.util.UUID;

public interface ProgressService {
    DashboardResponseDto getStudentDashboard(UUID studentUserId);
    void updateActivityAndStreak(UUID studentUserId);
}
