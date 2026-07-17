package com.careerforge.progress.repository;

import com.careerforge.progress.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, UUID> {
    Optional<Progress> findByStudentId(UUID studentId);
    Optional<Progress> findByStudentUserId(UUID userId);
}
