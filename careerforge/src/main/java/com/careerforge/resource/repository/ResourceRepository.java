package com.careerforge.resource.repository;

import com.careerforge.resource.entity.Resource;
import com.careerforge.resource.entity.ResourceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, UUID> {

    @Query("""
            SELECT r FROM Resource r
            WHERE (LOWER(r.title) LIKE LOWER(CONCAT('%', :query, '%'))
                   OR LOWER(r.description) LIKE LOWER(CONCAT('%', :query, '%')))
            AND (:type IS NULL OR r.type = :type)
            """)
    Page<Resource> searchAndFilterGlobal(
            @Param("query") String query,
            @Param("type") ResourceType type,
            Pageable pageable
    );

    @Query("""
            SELECT r FROM Resource r
            WHERE ((:folderId IS NULL AND r.folder IS NULL)
                   OR (:folderId IS NOT NULL AND r.folder.id = :folderId))
            AND (:type IS NULL OR r.type = :type)
            """)
    Page<Resource> searchAndFilterByFolder(
            @Param("folderId") UUID folderId,
            @Param("type") ResourceType type,
            Pageable pageable
    );
    
    long countByFolderId(UUID folderId);
}
