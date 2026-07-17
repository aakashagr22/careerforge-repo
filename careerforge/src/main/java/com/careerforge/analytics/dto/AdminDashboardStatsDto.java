package com.careerforge.analytics.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDashboardStatsDto {
    private long totalStudents;
    private long activeStudents;
    private long totalSheets;
    private long totalResources;
    private double averageStreak;
    private Map<String, Long> studentDistributionByBranch;
    private Map<String, Long> studentDistributionByCollege;
}
