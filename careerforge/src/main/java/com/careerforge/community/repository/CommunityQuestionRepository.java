package com.careerforge.community.repository;

import com.careerforge.community.entity.CommunityQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommunityQuestionRepository extends JpaRepository<CommunityQuestion, UUID> {
    Page<CommunityQuestion> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
