package com.careerforge.sheet.repository;

import com.careerforge.sheet.entity.StudentSheetProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentSheetProgressRepository extends JpaRepository<StudentSheetProgress, UUID> {
    Optional<StudentSheetProgress> findByStudentIdAndSheetTopicId(UUID studentId, UUID sheetTopicId);
    
    long countByStudentIdAndCompletedTrue(UUID studentId);

    @Query("SELECT COUNT(ssp) FROM StudentSheetProgress ssp WHERE ssp.student.id = :studentId AND ssp.sheetTopic.sheet.id = :sheetId AND ssp.completed = true")
    long countCompletedByStudentIdAndSheetId(@Param("studentId") UUID studentId, @Param("sheetId") UUID sheetId);

    List<StudentSheetProgress> findAllByStudentId(UUID studentId);
}
