package com.careerforge.student.dto;

import com.careerforge.student.entity.Language;
import com.careerforge.student.entity.TargetRole;
import com.careerforge.user.entity.Role;
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
public class StudentProfileResponse {
    private UUID id;
    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private boolean active;
    private Integer semester;
    private String branch;
    private String section;
    private String college;
    private String enrollmentNo;
    private Language preferredLanguage;
    private TargetRole targetRole;
    private boolean communicationTrackEnabled;
    private Integer streak;
    private String profileImage;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
