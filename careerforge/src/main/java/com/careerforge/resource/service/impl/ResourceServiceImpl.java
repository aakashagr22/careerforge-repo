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
import com.careerforge.resource.service.ResourceCacheService;
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
    private final ResourceCacheService resourceCacheService;

    public ResourceServiceImpl(ResourceRepository resourceRepository,
                               ResourceFolderRepository resourceFolderRepository,
                               UserRepository userRepository,
                               ResourceMapper resourceMapper,
                               ResourceCacheService resourceCacheService) {
        this.resourceRepository = resourceRepository;
        this.resourceFolderRepository = resourceFolderRepository;
        this.userRepository = userRepository;
        this.resourceMapper = resourceMapper;
        this.resourceCacheService = resourceCacheService != null ? resourceCacheService : new ResourceCacheService();
    }

    public ResourceServiceImpl(ResourceRepository resourceRepository,
                               ResourceFolderRepository resourceFolderRepository,
                               UserRepository userRepository,
                               ResourceMapper resourceMapper) {
        this(resourceRepository, resourceFolderRepository, userRepository, resourceMapper, new ResourceCacheService());
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
        resourceCacheService.clearDirectoryCache();
        resourceCacheService.clearSearchCache();
        log.info("Resource created with ID: {} by admin: {} and invalidated directory & search cache", savedResource.getId(), adminUserId);

        ResourceDto dto = resourceMapper.toDto(savedResource);
        resourceCacheService.putResource(savedResource.getId(), dto);
        return dto;
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
        resourceCacheService.clearDirectoryCache();
        resourceCacheService.clearSearchCache();
        resourceCacheService.evictResource(id);
        log.info("Resource updated with ID: {} and invalidated caches", updatedResource.getId());

        ResourceDto dto = resourceMapper.toDto(updatedResource);
        resourceCacheService.putResource(id, dto);
        return dto;
    }

    @Override
    public void deleteResource(UUID id) {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        resourceRepository.delete(resource);
        resourceCacheService.clearDirectoryCache();
        resourceCacheService.clearSearchCache();
        resourceCacheService.evictResource(id);
        log.info("Resource deleted with ID: {} and invalidated caches", id);
    }

    @Override
    @Transactional(readOnly = true)
    public ResourceDto getResourceById(UUID id) {
        ResourceDto cached = resourceCacheService.getResource(id);
        if (cached != null) {
            log.debug("Serving resource details from in-memory cache for ID: {}", id);
            return cached;
        }

        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        ResourceDto dto = resourceMapper.toDto(resource);
        resourceCacheService.putResource(id, dto);
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ResourceDto> searchAndFilterResources(String query, UUID folderId, ResourceType type, Pageable pageable) {
        String cacheKey = (query != null ? query.trim().toLowerCase() : "")
                + ":" + (folderId != null ? folderId.toString() : "all")
                + ":" + (type != null ? type.name() : "all")
                + ":" + pageable.getPageNumber()
                + ":" + pageable.getPageSize()
                + ":" + pageable.getSort();

        Page<ResourceDto> cached = resourceCacheService.getSearch(cacheKey);
        if (cached != null) {
            log.debug("Serving filtered resources from in-memory cache for key: {}", cacheKey);
            return cached;
        }

        Page<ResourceDto> result;
        if (query != null && !query.trim().isEmpty()) {
            result = resourceRepository.searchAndFilterGlobal(query.trim(), type, pageable)
                    .map(resourceMapper::toDto);
        } else {
            result = resourceRepository.searchAndFilterByFolder(folderId, type, pageable)
                    .map(resourceMapper::toDto);
        }

        resourceCacheService.putSearch(cacheKey, result);
        return result;
    }
}
