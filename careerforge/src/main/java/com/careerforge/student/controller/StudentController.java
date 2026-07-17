package com.careerforge.student.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.security.UserPrincipal;
import com.careerforge.student.dto.StudentProfileResponse;
import com.careerforge.student.dto.UpdateStudentProfileRequest;
import com.careerforge.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Student Profile Management", description = "APIs for managing student profiles")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/me")
    @Operation(summary = "Get current student profile")
    public ResponseEntity<ApiResponse<StudentProfileResponse>> getMyProfile(
            @AuthenticationPrincipal UserPrincipal principal) {
        StudentProfileResponse response = studentService.getStudentProfileByUserId(principal.getId());
        return ResponseEntity.ok(ApiResponse.success(response, "Student profile retrieved successfully"));
    }

    @PutMapping("/students/me")
    @Operation(summary = "Update current student profile")
    public ResponseEntity<ApiResponse<StudentProfileResponse>> updateMyProfile(
            @AuthenticationPrincipal UserPrincipal principal,
            @Valid @RequestBody UpdateStudentProfileRequest request) {
        StudentProfileResponse response = studentService.updateStudentProfile(principal.getId(), request);
        return ResponseEntity.ok(ApiResponse.success(response, "Student profile updated successfully"));
    }

    @GetMapping("/students/profile")
    @Operation(summary = "Find student profile by email or user ID")
    public ResponseEntity<ApiResponse<StudentProfileResponse>> getStudentProfile(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) UUID userId) {
        StudentProfileResponse response;
        if (email != null) {
            response = studentService.getStudentProfileByEmail(email);
        } else if (userId != null) {
            response = studentService.getStudentProfileByUserId(userId);
        } else {
            return ResponseEntity.badRequest().body(ApiResponse.success("Either 'email' or 'userId' parameter must be provided"));
        }
        return ResponseEntity.ok(ApiResponse.success(response, "Student profile retrieved successfully"));
    }

    // --- Admin Endpoints ---

    @GetMapping("/api/admin/students")
    @Operation(summary = "Get paginated list of all students (Admin)")
    public ResponseEntity<ApiResponse<Page<StudentProfileResponse>>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<StudentProfileResponse> response = studentService.getAllStudentProfiles(pageable);
        return ResponseEntity.ok(ApiResponse.success(response, "Students retrieved successfully"));
    }

    @DeleteMapping("/api/admin/students/{id}")
    @Operation(summary = "Delete student profile (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudentProfile(id);
        return ResponseEntity.ok(ApiResponse.success("Student profile deleted successfully"));
    }
}
