package com.careerforge.roadmap.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapPhaseDto {
    private UUID id;
    private UUID roadmapId;
    private String title;
    private String description;
    private Integer startMonth;
    private Integer endMonth;
    private Integer priority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
