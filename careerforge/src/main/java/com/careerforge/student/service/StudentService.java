package com.careerforge.student.service;

import com.careerforge.student.dto.StudentProfileResponse;
import com.careerforge.student.dto.UpdateStudentProfileRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface StudentService {
    StudentProfileResponse getStudentProfileByUserId(UUID userId);
    StudentProfileResponse getStudentProfileByEmail(String email);
    StudentProfileResponse updateStudentProfile(UUID userId, UpdateStudentProfileRequest request);
    Page<StudentProfileResponse> getAllStudentProfiles(Pageable pageable);
    void deleteStudentProfile(UUID id);
}
