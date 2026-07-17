package com.careerforge.roadmap.repository;

import com.careerforge.roadmap.entity.Roadmap;
import com.careerforge.student.entity.Language;
import com.careerforge.student.entity.TargetRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoadmapRepository extends JpaRepository<Roadmap, UUID> {
    Optional<Roadmap> findBySemesterAndLanguageAndTargetRole(
            Integer semester, Language language, TargetRole targetRole);
}
