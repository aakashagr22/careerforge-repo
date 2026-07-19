package com.careerforge.resource.repository;

import com.careerforge.resource.entity.ResourceFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResourceFolderRepository extends JpaRepository<ResourceFolder, UUID> {
    
    List<ResourceFolder> findByParentIdOrderByCreatedAtAsc(UUID parentId);
    
    List<ResourceFolder> findByParentIdIsNullOrderByCreatedAtAsc();
    
    boolean existsByNameIgnoreCaseAndParentId(String name, UUID parentId);
    
    boolean existsByNameIgnoreCaseAndParentIdIsNull(String name);
    
    long countByParentId(UUID parentId);
}
