package com.careerforge.roadmap.dto;

import com.careerforge.student.entity.Language;
import com.careerforge.student.entity.TargetRole;
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
public class RoadmapDto {
    private UUID id;
    private Integer semester;
    private Integer monthsRemaining;
    private Language language;
    private TargetRole targetRole;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
