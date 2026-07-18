package com.careerforge.roadmap.repository;

import com.careerforge.roadmap.entity.StudentRoadmapQuestionProgress;
import com.careerforge.roadmap.entity.StudentRoadmapQuestionProgressId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRoadmapQuestionProgressRepository extends JpaRepository<StudentRoadmapQuestionProgress, StudentRoadmapQuestionProgressId> {
    List<StudentRoadmapQuestionProgress> findByStudentId(UUID studentId);
    
    long countByStudentIdAndCompletedTrue(UUID studentId);
    
    long countByStudentIdAndRoadmapSectionQuestionRoadmapSectionRoadmapIdAndCompletedTrue(UUID studentId, UUID roadmapId);
}
