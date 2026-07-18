package com.careerforge.roadmap.repository;

import com.careerforge.roadmap.entity.RoadmapSectionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoadmapSectionQuestionRepository extends JpaRepository<RoadmapSectionQuestion, UUID> {
    List<RoadmapSectionQuestion> findByRoadmapSectionIdOrderByPositionAsc(UUID sectionId);
    List<RoadmapSectionQuestion> findByRoadmapSectionRoadmapId(UUID roadmapId);
}
