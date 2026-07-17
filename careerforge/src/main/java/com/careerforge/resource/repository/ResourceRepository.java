package com.careerforge.resource.repository;

import com.careerforge.common.entity.Difficulty;
import com.careerforge.resource.entity.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, UUID> {

    @Query("""
            SELECT r FROM Resource r
            WHERE (:query IS NULL OR LOWER(r.title) LIKE LOWER(CONCAT('%', :query, '%'))
                   OR LOWER(r.description) LIKE LOWER(CONCAT('%', :query, '%')))
            AND (:category IS NULL OR r.category = :category)
            AND (:type IS NULL OR r.type = :type)
            AND (:difficulty IS NULL OR r.difficulty = :difficulty)
            """)
    Page<Resource> searchAndFilter(
            @Param("query") String query,
            @Param("category") String category,
            @Param("type") String type,
            @Param("difficulty") Difficulty difficulty,
            Pageable pageable
    );

    Page<Resource> findByCategory(String category, Pageable pageable);

    Page<Resource> findByDifficulty(Difficulty difficulty, Pageable pageable);
}
