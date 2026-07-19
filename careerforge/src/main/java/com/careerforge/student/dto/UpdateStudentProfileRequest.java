package com.careerforge.student.dto;

import com.careerforge.student.entity.Language;
import com.careerforge.student.entity.TargetRole;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentProfileRequest {

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    @Min(value = 1, message = "Semester must be at least 1")
    @Max(value = 8, message = "Semester cannot exceed 8")
    private Integer semester;

    @NotBlank(message = "Branch is required")
    private String branch;

    private String section;

    @NotBlank(message = "Enrollment number is required")
    private String enrollmentNo;

    @NotNull(message = "Preferred language is required")
    private Language preferredLanguage;

    @NotNull(message = "Target role is required")
    private TargetRole targetRole;

    @Min(value = 1, message = "Starting semester must be at least 1")
    @Max(value = 5, message = "Starting semester cannot exceed 5")
    private Integer startingSemester;

    @Size(max = 50, message = "Framework must not exceed 50 characters")
    private String framework;

    private String profileImage;
}
