package com.careerforge.student.service.impl;

import com.careerforge.exception.BadRequestException;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.student.dto.StudentProfileResponse;
import com.careerforge.student.dto.UpdateStudentProfileRequest;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.mapper.StudentMapper;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.student.service.StudentService;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentProfileRepository studentProfileRepository;
    private final UserRepository userRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentProfileRepository studentProfileRepository,
                              UserRepository userRepository,
                              StudentMapper studentMapper) {
        this.studentProfileRepository = studentProfileRepository;
        this.userRepository = userRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public StudentProfileResponse getStudentProfileByUserId(UUID userId) {
        StudentProfile profile = studentProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for user ID: " + userId));
        return studentMapper.toResponse(profile);
    }

    @Override
    @Transactional(readOnly = true)
    public StudentProfileResponse getStudentProfileByEmail(String email) {
        StudentProfile profile = studentProfileRepository.findByUserEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for email: " + email));
        return studentMapper.toResponse(profile);
    }

    @Override
    public StudentProfileResponse updateStudentProfile(UUID userId, UpdateStudentProfileRequest request) {
        StudentProfile profile = studentProfileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for user ID: " + userId));

        // Check if enrollment number is unique if modified
        if (!Objects.equals(profile.getEnrollmentNo(), request.getEnrollmentNo())) {
            if (studentProfileRepository.existsByEnrollmentNo(request.getEnrollmentNo())) {
                throw new BadRequestException("Enrollment number already exists: " + request.getEnrollmentNo());
            }
        }

        // Update User info
        User user = profile.getUser();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        userRepository.save(user);

        // Update Profile info
        profile.setSemester(request.getSemester());
        profile.setBranch(request.getBranch());
        profile.setSection(request.getSection());
        profile.setCollege(request.getCollege());
        profile.setEnrollmentNo(request.getEnrollmentNo());
        profile.setPreferredLanguage(request.getPreferredLanguage());
        profile.setTargetRole(request.getTargetRole());
        profile.setCommunicationTrackEnabled(request.isCommunicationTrackEnabled());
        profile.setProfileImage(request.getProfileImage());

        StudentProfile updatedProfile = studentProfileRepository.save(profile);
        return studentMapper.toResponse(updatedProfile);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StudentProfileResponse> getAllStudentProfiles(Pageable pageable) {
        return studentProfileRepository.findAll(pageable)
                .map(studentMapper::toResponse);
    }

    @Override
    public void deleteStudentProfile(UUID id) {
        StudentProfile profile = studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found with ID: " + id));

        // Deactivate corresponding user as a safety
        User user = profile.getUser();
        user.setActive(false);
        userRepository.save(user);

        studentProfileRepository.delete(profile);
    }
}
