package com.careerforge.roadmap.repository;

import com.careerforge.roadmap.entity.RoadmapPhase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoadmapPhaseRepository extends JpaRepository<RoadmapPhase, UUID> {
    List<RoadmapPhase> findByRoadmapIdOrderByPriorityAsc(UUID roadmapId);
}
