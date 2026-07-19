package com.careerforge.suggestion.repository;

import com.careerforge.suggestion.entity.Suggestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, UUID> {

    Page<Suggestion> findByStudentIdOrderByCreatedAtDesc(UUID studentId, Pageable pageable);

    Page<Suggestion> findAllByOrderByCreatedAtDesc(Pageable pageable);

    long countByStudentIdAndCreatedAtAfter(UUID studentId, LocalDateTime dateTime);
}
