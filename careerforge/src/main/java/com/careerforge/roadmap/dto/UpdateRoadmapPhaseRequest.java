package com.careerforge.roadmap.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoadmapPhaseRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Start month is required")
    @Min(value = 1, message = "Start month must be at least 1")
    private Integer startMonth;

    @NotNull(message = "End month is required")
    @Min(value = 1, message = "End month must be at least 1")
    private Integer endMonth;

    @NotNull(message = "Priority is required")
    @Min(value = 1, message = "Priority must be at least 1")
    private Integer priority;
}
