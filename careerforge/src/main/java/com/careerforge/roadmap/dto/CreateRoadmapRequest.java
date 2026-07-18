package com.careerforge.roadmap.dto;

import com.careerforge.student.entity.TargetRole;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoadmapRequest {

    @NotNull(message = "Semester is required")
    @Min(value = 1, message = "Semester must be at least 1")
    @Max(value = 8, message = "Semester cannot exceed 8")
    private Integer semester;

    @NotNull(message = "Months remaining is required")
    @Min(value = 1, message = "Months remaining must be at least 1")
    private Integer monthsRemaining;

    @NotEmpty(message = "At least one target role is required")
    private List<TargetRole> targetRoles;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
}
