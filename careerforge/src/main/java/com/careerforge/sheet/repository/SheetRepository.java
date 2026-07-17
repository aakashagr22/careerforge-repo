package com.careerforge.sheet.repository;

import com.careerforge.sheet.entity.Sheet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SheetRepository extends JpaRepository<Sheet, UUID> {
    Page<Sheet> findByCategory(String category, Pageable pageable);
}
