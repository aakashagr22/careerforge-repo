package com.careerforge.roadmap.repository;

import com.careerforge.roadmap.entity.QuestionLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestionLinkRepository extends JpaRepository<QuestionLink, UUID> {
}
