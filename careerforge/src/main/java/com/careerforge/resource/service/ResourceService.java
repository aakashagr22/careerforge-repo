package com.careerforge.resource.service;

import com.careerforge.common.entity.Difficulty;
import com.careerforge.resource.dto.CreateResourceRequest;
import com.careerforge.resource.dto.ResourceDto;
import com.careerforge.resource.dto.UpdateResourceRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ResourceService {
    ResourceDto createResource(CreateResourceRequest request, UUID adminUserId);
    ResourceDto updateResource(UUID id, UpdateResourceRequest request);
    void deleteResource(UUID id);
    ResourceDto getResourceById(UUID id);
    Page<ResourceDto> searchAndFilterResources(String query, UUID folderId, com.careerforge.resource.entity.ResourceType type, Pageable pageable);
}
