package com.careerforge.student.repository;

import com.careerforge.student.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, UUID> {
    Optional<StudentProfile> findByUserId(UUID userId);
    Optional<StudentProfile> findByUserEmail(String email);
    boolean existsByEnrollmentNo(String enrollmentNo);

    @org.springframework.data.jpa.repository.Query("SELECT COALESCE(AVG(s.streak), 0.0) FROM StudentProfile s")
    Double getAverageStreak();

    @org.springframework.data.jpa.repository.Query("SELECT s.branch, COUNT(s) FROM StudentProfile s GROUP BY s.branch")
    java.util.List<Object[]> getBranchDistribution();

    @org.springframework.data.jpa.repository.Query("SELECT s.college, COUNT(s) FROM StudentProfile s GROUP BY s.college")
    java.util.List<Object[]> getCollegeDistribution();
}
