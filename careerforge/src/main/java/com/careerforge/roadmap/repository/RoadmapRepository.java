package com.careerforge.roadmap.repository;

import com.careerforge.roadmap.entity.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoadmapRepository extends JpaRepository<Roadmap, UUID> {
    @Query(value = "SELECT * FROM roadmaps r WHERE r.semester = :semester AND :targetRole = ANY(r.target_roles)", nativeQuery = true)
    Optional<Roadmap> findBySemesterAndTargetRole(
            @Param("semester") Integer semester, 
            @Param("targetRole") String targetRole);
}
