package com.careerforge.resource;

import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.resource.dto.*;
import com.careerforge.resource.entity.Resource;
import com.careerforge.resource.entity.ResourceFolder;
import com.careerforge.resource.entity.ResourceType;
import com.careerforge.resource.mapper.ResourceMapper;
import com.careerforge.resource.repository.ResourceFolderRepository;
import com.careerforge.resource.repository.ResourceRepository;
import com.careerforge.resource.service.impl.ResourceFolderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResourceFolderServiceTest {

    @Mock
    private ResourceFolderRepository resourceFolderRepository;

    @Mock
    private ResourceRepository resourceRepository;

    @Mock
    private ResourceMapper resourceMapper;

    @InjectMocks
    private ResourceFolderServiceImpl resourceFolderService;

    private ResourceFolder rootFolder;
    private ResourceFolder childFolder;

    @BeforeEach
    void setUp() {
        rootFolder = ResourceFolder.builder()
                .id(UUID.randomUUID())
                .name("Root Folder")
                .parentFolder(null)
                .build();

        childFolder = ResourceFolder.builder()
                .id(UUID.randomUUID())
                .name("Child Folder")
                .parentFolder(rootFolder)
                .build();
    }

    @Test
    void createFolder_AtRoot_ShouldSucceed_WhenNameIsUnique() {
        CreateFolderRequest request = CreateFolderRequest.builder()
                .name("New Root Folder")
                .parentId(null)
                .build();

        when(resourceFolderRepository.findByParentIdIsNullOrderByCreatedAtAsc()).thenReturn(Collections.emptyList());
        when(resourceFolderRepository.save(any(ResourceFolder.class))).thenAnswer(invocation -> {
            ResourceFolder folder = invocation.getArgument(0);
            folder.setId(UUID.randomUUID());
            return folder;
        });

        FolderDto result = resourceFolderService.createFolder(request);

        assertNotNull(result);
        assertEquals("New Root Folder", result.getName());
        assertNull(result.getParentId());
        verify(resourceFolderRepository, times(1)).save(any(ResourceFolder.class));
    }

    @Test
    void createFolder_DuplicateName_ShouldThrowException() {
        CreateFolderRequest request = CreateFolderRequest.builder()
                .name("Root Folder")
                .parentId(null)
                .build();

        when(resourceFolderRepository.findByParentIdIsNullOrderByCreatedAtAsc()).thenReturn(List.of(rootFolder));

        assertThrows(IllegalArgumentException.class, () -> resourceFolderService.createFolder(request));
        verify(resourceFolderRepository, never()).save(any(ResourceFolder.class));
    }

    @Test
    void updateFolder_WithCycle_ShouldThrowException() {
        UpdateFolderRequest request = UpdateFolderRequest.builder()
                .name("Root Folder Updated")
                .parentId(childFolder.getId()) // Attempt to move root folder inside its own child
                .build();

        when(resourceFolderRepository.findById(rootFolder.getId())).thenReturn(Optional.of(rootFolder));
        when(resourceFolderRepository.findById(childFolder.getId())).thenReturn(Optional.of(childFolder));

        assertThrows(IllegalArgumentException.class, () -> resourceFolderService.updateFolder(rootFolder.getId(), request));
        verify(resourceFolderRepository, never()).save(any(ResourceFolder.class));
    }

    @Test
    void deleteFolder_NotEmpty_ShouldThrowException() {
        // Mock folder containing subfolders
        when(resourceFolderRepository.findById(rootFolder.getId())).thenReturn(Optional.of(rootFolder));
        when(resourceFolderRepository.countByParentId(rootFolder.getId())).thenReturn(1L);

        assertThrows(IllegalArgumentException.class, () -> resourceFolderService.deleteFolder(rootFolder.getId()));
        verify(resourceFolderRepository, never()).delete(any(ResourceFolder.class));
    }

    @Test
    void deleteFolder_Empty_ShouldSucceed() {
        when(resourceFolderRepository.findById(childFolder.getId())).thenReturn(Optional.of(childFolder));
        when(resourceFolderRepository.countByParentId(childFolder.getId())).thenReturn(0L);
        when(resourceRepository.countByFolderId(childFolder.getId())).thenReturn(0L);

        assertDoesNotThrow(() -> resourceFolderService.deleteFolder(childFolder.getId()));
        verify(resourceFolderRepository, times(1)).delete(childFolder);
    }

    @Test
    void getFolderDirectory_ShouldReturnOnlyDirectChildren() {
        Pageable pageable = PageRequest.of(0, 10);
        Resource resource = Resource.builder()
                .id(UUID.randomUUID())
                .title("Resource Title")
                .type(ResourceType.VIDEO)
                .folder(childFolder)
                .build();

        ResourceDto resourceDto = ResourceDto.builder()
                .id(resource.getId())
                .title("Resource Title")
                .type("VIDEO")
                .folderId(childFolder.getId())
                .build();

        when(resourceFolderRepository.findById(childFolder.getId())).thenReturn(Optional.of(childFolder));
        when(resourceFolderRepository.findByParentIdOrderByCreatedAtAsc(childFolder.getId())).thenReturn(Collections.emptyList());
        when(resourceRepository.searchAndFilterByFolder(childFolder.getId(), null, pageable))
                .thenReturn(new PageImpl<>(List.of(resource)));
        when(resourceMapper.toDto(resource)).thenReturn(resourceDto);

        FolderDirectoryDto directory = resourceFolderService.getFolderDirectory(childFolder.getId(), null, pageable);

        assertNotNull(directory);
        assertEquals(childFolder.getName(), directory.getCurrentFolder().getName());
        assertEquals(2, directory.getBreadcrumbs().size()); // Root Folder > Child Folder
        assertEquals(0, directory.getChildFolders().size());
        assertEquals(1, directory.getResources().getTotalElements());
        assertEquals("Resource Title", directory.getResources().getContent().get(0).getTitle());
    }
}
