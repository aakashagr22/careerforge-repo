package com.careerforge.progress.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponseDto {
    private long completedTopics;
    private long completedSheets;
    private double roadmapProgress;
    private int currentStreak;
    private List<WeeklyProgressDto> weeklyProgress;
}
