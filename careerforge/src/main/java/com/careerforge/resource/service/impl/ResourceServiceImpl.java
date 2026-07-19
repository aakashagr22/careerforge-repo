package com.careerforge.resource.service.impl;

import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.resource.dto.CreateResourceRequest;
import com.careerforge.resource.dto.ResourceDto;
import com.careerforge.resource.dto.UpdateResourceRequest;
import com.careerforge.resource.entity.Resource;
import com.careerforge.resource.entity.ResourceFolder;
import com.careerforge.resource.entity.ResourceType;
import com.careerforge.resource.mapper.ResourceMapper;
import com.careerforge.resource.repository.ResourceFolderRepository;
import com.careerforge.resource.repository.ResourceRepository;
import com.careerforge.resource.service.ResourceService;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceFolderRepository resourceFolderRepository;
    private final UserRepository userRepository;
    private final ResourceMapper resourceMapper;

    public ResourceServiceImpl(ResourceRepository resourceRepository,
                               ResourceFolderRepository resourceFolderRepository,
                               UserRepository userRepository,
                               ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceFolderRepository = resourceFolderRepository;
        this.userRepository = userRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public ResourceDto createResource(CreateResourceRequest request, UUID adminUserId) {
        User admin = userRepository.findById(adminUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin user not found with id: " + adminUserId));

        ResourceFolder folder = null;
        if (request.getFolderId() != null) {
            folder = resourceFolderRepository.findById(request.getFolderId())
                    .orElseThrow(() -> new ResourceNotFoundException("Folder not found with id: " + request.getFolderId()));
        }

        Resource resource = Resource.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .type(request.getType())
                .url(request.getUrl())
                .thumbnail(request.getThumbnail())
                .folder(folder)
                .createdBy(admin)
                .build();

        Resource savedResource = resourceRepository.save(resource);
        log.info("Resource created with ID: {} by admin: {}", savedResource.getId(), adminUserId);
        return resourceMapper.toDto(savedResource);
    }

    @Override
    public ResourceDto updateResource(UUID id, UpdateResourceRequest request) {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));

        ResourceFolder folder = null;
        if (request.getFolderId() != null) {
            folder = resourceFolderRepository.findById(request.getFolderId())
                    .orElseThrow(() -> new ResourceNotFoundException("Folder not found with id: " + request.getFolderId()));
        }

        resource.setTitle(request.getTitle());
        resource.setDescription(request.getDescription());
        resource.setType(request.getType());
        resource.setUrl(request.getUrl());
        resource.setThumbnail(request.getThumbnail());
        resource.setFolder(folder);

        Resource updatedResource = resourceRepository.save(resource);
        log.info("Resource updated with ID: {}", updatedResource.getId());
        return resourceMapper.toDto(updatedResource);
    }

    @Override
    public void deleteResource(UUID id) {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        resourceRepository.delete(resource);
        log.info("Resource deleted with ID: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public ResourceDto getResourceById(UUID id) {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        return resourceMapper.toDto(resource);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ResourceDto> searchAndFilterResources(String query, UUID folderId, ResourceType type, Pageable pageable) {
        if (query != null && !query.trim().isEmpty()) {
            return resourceRepository.searchAndFilterGlobal(query.trim(), type, pageable)
                    .map(resourceMapper::toDto);
        } else {
            return resourceRepository.searchAndFilterByFolder(folderId, type, pageable)
                    .map(resourceMapper::toDto);
        }
    }
}
