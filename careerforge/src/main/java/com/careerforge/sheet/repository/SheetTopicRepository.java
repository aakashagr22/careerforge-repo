package com.careerforge.sheet.repository;

import com.careerforge.sheet.entity.SheetTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SheetTopicRepository extends JpaRepository<SheetTopic, UUID> {
    List<SheetTopic> findBySheetIdOrderByOrderIndexAsc(UUID sheetId);
    long countBySheetId(UUID sheetId);
}
