package com.careerforge.community.repository;

import com.careerforge.community.entity.CommunityAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommunityAnswerRepository extends JpaRepository<CommunityAnswer, UUID> {
    List<CommunityAnswer> findByQuestionIdOrderByCreatedAtAsc(UUID questionId);
    long countByQuestionId(UUID questionId);
}
