package com.careerforge.resource.service.impl;

import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.resource.dto.*;
import com.careerforge.resource.entity.ResourceFolder;
import com.careerforge.resource.mapper.ResourceMapper;
import com.careerforge.resource.repository.ResourceFolderRepository;
import com.careerforge.resource.repository.ResourceRepository;
import com.careerforge.resource.service.ResourceFolderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class ResourceFolderServiceImpl implements ResourceFolderService {

    private final ResourceFolderRepository resourceFolderRepository;
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    public ResourceFolderServiceImpl(ResourceFolderRepository resourceFolderRepository,
                                     ResourceRepository resourceRepository,
                                     ResourceMapper resourceMapper) {
        this.resourceFolderRepository = resourceFolderRepository;
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public FolderDto createFolder(CreateFolderRequest request) {
        ResourceFolder parent = null;
        if (request.getParentId() != null) {
            parent = resourceFolderRepository.findById(request.getParentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent folder not found with id: " + request.getParentId()));
        }

        // Validate uniqueness of name at this level
        validateNameUniqueness(request.getName(), request.getParentId(), null);

        ResourceFolder folder = ResourceFolder.builder()
                .name(request.getName().trim())
                .parentFolder(parent)
                .build();

        ResourceFolder saved = resourceFolderRepository.save(folder);
        log.info("Created resource folder: {} (id: {})", saved.getName(), saved.getId());
        return toFolderDto(saved);
    }

    @Override
    public FolderDto updateFolder(UUID id, UpdateFolderRequest request) {
        ResourceFolder folder = resourceFolderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Folder not found with id: " + id));

        ResourceFolder parent = null;
        if (request.getParentId() != null) {
            parent = resourceFolderRepository.findById(request.getParentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Parent folder not found with id: " + request.getParentId()));
        }

        // Validate cycle if moving
        if (request.getParentId() != null) {
            validateCycle(id, request.getParentId());
        }

        // Validate uniqueness of name at the target level
        validateNameUniqueness(request.getName(), request.getParentId(), id);

        folder.setName(request.getName().trim());
        folder.setParentFolder(parent);

        ResourceFolder saved = resourceFolderRepository.save(folder);
        log.info("Updated resource folder: {} (id: {})", saved.getName(), saved.getId());
        return toFolderDto(saved);
    }

    @Override
    public void deleteFolder(UUID id) {
        ResourceFolder folder = resourceFolderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Folder not found with id: " + id));

        // Reject if folder is not empty
        long subfolderCount = resourceFolderRepository.countByParentId(id);
        long resourceCount = resourceRepository.countByFolderId(id);
        if (subfolderCount > 0 || resourceCount > 0) {
            throw new IllegalArgumentException("Cannot delete folder because it contains " 
                    + subfolderCount + " subfolders and " + resourceCount + " resources.");
        }

        resourceFolderRepository.delete(folder);
        log.info("Deleted resource folder with id: {}", id);
    }

    @Override
    @Transactional(readOnly = true)
    public FolderDirectoryDto getFolderDirectory(UUID folderId, Pageable pageable) {
        FolderDto currentFolderDto = null;
        List<FolderBreadcrumbDto> breadcrumbs = new ArrayList<>();
        List<FolderDto> childFolders;
        Page<ResourceDto> resources;

        if (folderId != null) {
            ResourceFolder current = resourceFolderRepository.findById(folderId)
                    .orElseThrow(() -> new ResourceNotFoundException("Folder not found with id: " + folderId));

            currentFolderDto = toFolderDto(current);

            // Build breadcrumbs
            ResourceFolder temp = current;
            while (temp != null) {
                breadcrumbs.add(FolderBreadcrumbDto.builder()
                        .id(temp.getId())
                        .name(temp.getName())
                        .build());
                temp = temp.getParentFolder();
            }
            Collections.reverse(breadcrumbs);

            // Fetch direct child folders
            childFolders = resourceFolderRepository.findByParentIdOrderByCreatedAtAsc(folderId).stream()
                    .map(this::toFolderDto)
                    .collect(Collectors.toList());

            // Fetch direct resources inside this folder (no category/difficulty filter)
            resources = resourceRepository.searchAndFilterByFolder(folderId, null, pageable)
                    .map(resourceMapper::toDto);

        } else {
            // Root level directory
            childFolders = resourceFolderRepository.findByParentIdIsNullOrderByCreatedAtAsc().stream()
                    .map(this::toFolderDto)
                    .collect(Collectors.toList());

            resources = resourceRepository.searchAndFilterByFolder(null, null, pageable)
                    .map(resourceMapper::toDto);
        }

        return FolderDirectoryDto.builder()
                .currentFolder(currentFolderDto)
                .breadcrumbs(breadcrumbs)
                .childFolders(childFolders)
                .resources(resources)
                .build();
    }

    private FolderDto toFolderDto(ResourceFolder folder) {
        if (folder == null) return null;
        return FolderDto.builder()
                .id(folder.getId())
                .name(folder.getName())
                .parentId(folder.getParentFolder() != null ? folder.getParentFolder().getId() : null)
                .createdAt(folder.getCreatedAt())
                .updatedAt(folder.getUpdatedAt())
                .build();
    }

    private void validateNameUniqueness(String name, UUID parentId, UUID folderIdToIgnore) {
        List<ResourceFolder> siblings;
        if (parentId == null) {
            siblings = resourceFolderRepository.findByParentIdIsNullOrderByCreatedAtAsc();
        } else {
            siblings = resourceFolderRepository.findByParentIdOrderByCreatedAtAsc(parentId);
        }

        boolean exists = siblings.stream()
                .anyMatch(f -> f.getName().equalsIgnoreCase(name.trim()) 
                        && !f.getId().equals(folderIdToIgnore));

        if (exists) {
            throw new IllegalArgumentException("A folder named '" + name.trim() + "' already exists at this level.");
        }
    }

    private void validateCycle(UUID folderId, UUID proposedParentId) {
        if (folderId.equals(proposedParentId)) {
            throw new IllegalArgumentException("A folder cannot become its own parent.");
        }

        ResourceFolder parent = resourceFolderRepository.findById(proposedParentId)
                .orElseThrow(() -> new ResourceNotFoundException("Proposed parent folder not found."));

        ResourceFolder temp = parent;
        while (temp != null) {
            if (temp.getId().equals(folderId)) {
                throw new IllegalArgumentException("A folder cannot become a descendant of itself.");
            }
            temp = temp.getParentFolder();
        }
    }
}
