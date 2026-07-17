package com.careerforge.student;

import com.careerforge.exception.BadRequestException;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.student.dto.StudentProfileResponse;
import com.careerforge.student.dto.UpdateStudentProfileRequest;
import com.careerforge.student.entity.Language;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.entity.TargetRole;
import com.careerforge.student.mapper.StudentMapper;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.student.service.impl.StudentServiceImpl;
import com.careerforge.user.entity.Role;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentProfileRepository studentProfileRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    private UUID userId;
    private User user;
    private StudentProfile studentProfile;
    private UpdateStudentProfileRequest updateRequest;
    private StudentProfileResponse response;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
        user = User.builder()
                .id(userId)
                .firstName("Alice")
                .lastName("Smith")
                .email("alice.smith@example.com")
                .role(Role.STUDENT)
                .active(true)
                .build();

        studentProfile = StudentProfile.builder()
                .id(UUID.randomUUID())
                .user(user)
                .semester(5)
                .branch("Computer Science")
                .college("Engineering College")
                .enrollmentNo("CS12345")
                .preferredLanguage(Language.JAVA)
                .targetRole(TargetRole.SDE)
                .communicationTrackEnabled(true)
                .streak(5)
                .build();

        updateRequest = UpdateStudentProfileRequest.builder()
                .firstName("Alice M.")
                .lastName("Smith")
                .semester(6)
                .branch("Computer Science")
                .college("Engineering College")
                .enrollmentNo("CS12345") // same
                .preferredLanguage(Language.PYTHON)
                .targetRole(TargetRole.FULL_STACK)
                .communicationTrackEnabled(true)
                .build();

        response = StudentProfileResponse.builder()
                .userId(userId)
                .firstName("Alice M.")
                .lastName("Smith")
                .semester(6)
                .preferredLanguage(Language.PYTHON)
                .targetRole(TargetRole.FULL_STACK)
                .build();
    }

    @Test
    void getStudentProfileByUserId_ShouldReturnProfile_WhenExists() {
        when(studentProfileRepository.findByUserId(userId)).thenReturn(Optional.of(studentProfile));
        when(studentMapper.toResponse(studentProfile)).thenReturn(response);

        StudentProfileResponse result = studentService.getStudentProfileByUserId(userId);

        assertNotNull(result);
        assertEquals("Alice M.", result.getFirstName());
        verify(studentProfileRepository, times(1)).findByUserId(userId);
    }

    @Test
    void getStudentProfileByUserId_ShouldThrowException_WhenNotExists() {
        when(studentProfileRepository.findByUserId(userId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> studentService.getStudentProfileByUserId(userId));
    }

    @Test
    void updateStudentProfile_ShouldModifyFields_WhenValid() {
        when(studentProfileRepository.findByUserId(userId)).thenReturn(Optional.of(studentProfile));
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(studentProfileRepository.save(any(StudentProfile.class))).thenReturn(studentProfile);
        when(studentMapper.toResponse(studentProfile)).thenReturn(response);

        StudentProfileResponse result = studentService.updateStudentProfile(userId, updateRequest);

        assertNotNull(result);
        assertEquals(Language.PYTHON, studentProfile.getPreferredLanguage());
        assertEquals("Alice M.", user.getFirstName());
        verify(userRepository, times(1)).save(user);
        verify(studentProfileRepository, times(1)).save(studentProfile);
    }

    @Test
    void updateStudentProfile_ShouldThrowException_WhenEnrollmentNumberDuplicate() {
        updateRequest.setEnrollmentNo("CS99999"); // Changed enrollment number
        when(studentProfileRepository.findByUserId(userId)).thenReturn(Optional.of(studentProfile));
        when(studentProfileRepository.existsByEnrollmentNo("CS99999")).thenReturn(true); // Exists elsewhere

        assertThrows(BadRequestException.class, () -> studentService.updateStudentProfile(userId, updateRequest));
        verify(userRepository, never()).save(any(User.class));
    }
}
