package com.careerforge.roadmap.dto;

import com.careerforge.student.entity.TargetRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapDto {
    private UUID id;
    private Integer semester;
    private Integer monthsRemaining;
    private List<TargetRole> targetRoles;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
