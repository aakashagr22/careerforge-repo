package com.careerforge.roadmap.repository;

import com.careerforge.roadmap.entity.RoadmapSectionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoadmapSectionQuestionRepository extends JpaRepository<RoadmapSectionQuestion, UUID> {
    List<RoadmapSectionQuestion> findByRoadmapSectionIdOrderByPositionAsc(UUID sectionId);

    @Query("SELECT rsq FROM RoadmapSectionQuestion rsq " +
           "JOIN FETCH rsq.question q " +
           "LEFT JOIN FETCH q.links " +
           "WHERE rsq.roadmapSection.roadmap.id = :roadmapId")
    List<RoadmapSectionQuestion> findByRoadmapSectionRoadmapId(@Param("roadmapId") UUID roadmapId);
}
