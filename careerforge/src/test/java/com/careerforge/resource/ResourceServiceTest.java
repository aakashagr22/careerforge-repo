package com.careerforge.resource;

import com.careerforge.common.entity.Difficulty;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.resource.dto.CreateResourceRequest;
import com.careerforge.resource.dto.ResourceDto;
import com.careerforge.resource.dto.UpdateResourceRequest;
import com.careerforge.resource.entity.Resource;
import com.careerforge.resource.mapper.ResourceMapper;
import com.careerforge.resource.repository.ResourceRepository;
import com.careerforge.resource.service.impl.ResourceServiceImpl;
import com.careerforge.user.entity.Role;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResourceServiceTest {

    @Mock
    private ResourceRepository resourceRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ResourceMapper resourceMapper;

    @InjectMocks
    private ResourceServiceImpl resourceService;

    private UUID adminId;
    private User admin;
    private Resource resource;
    private ResourceDto resourceDto;
    private CreateResourceRequest createRequest;
    private UpdateResourceRequest updateRequest;

    @BeforeEach
    void setUp() {
        adminId = UUID.randomUUID();
        admin = User.builder()
                .id(adminId)
                .firstName("Admin")
                .lastName("User")
                .email("admin@careerforge.com")
                .role(Role.ADMIN)
                .active(true)
                .build();

        resource = Resource.builder()
                .id(UUID.randomUUID())
                .title("Two Pointers Technique")
                .description("Learn the two pointers approach for arrays")
                .type(com.careerforge.resource.entity.ResourceType.ARTICLE)
                .url("https://example.com/two-pointers")
                .thumbnail("https://example.com/thumb.png")
                .createdBy(admin)
                .build();

        resourceDto = ResourceDto.builder()
                .id(resource.getId())
                .title("Two Pointers Technique")
                .description("Learn the two pointers approach for arrays")
                .type("ARTICLE")
                .url("https://example.com/two-pointers")
                .createdById(adminId)
                .createdByName("Admin User")
                .build();

        createRequest = CreateResourceRequest.builder()
                .title("Two Pointers Technique")
                .description("Learn the two pointers approach for arrays")
                .type(com.careerforge.resource.entity.ResourceType.ARTICLE)
                .url("https://example.com/two-pointers")
                .thumbnail("https://example.com/thumb.png")
                .build();

        updateRequest = UpdateResourceRequest.builder()
                .title("Two Pointers Technique (Updated)")
                .description("Updated description")
                .type(com.careerforge.resource.entity.ResourceType.VIDEO)
                .url("https://example.com/two-pointers-v2")
                .build();
    }

    @Test
    void createResource_ShouldSaveAndReturnDto_WhenAdminExists() {
        when(userRepository.findById(adminId)).thenReturn(Optional.of(admin));
        when(resourceRepository.save(any(Resource.class))).thenReturn(resource);
        when(resourceMapper.toDto(resource)).thenReturn(resourceDto);

        ResourceDto result = resourceService.createResource(createRequest, adminId);

        assertNotNull(result);
        assertEquals("Two Pointers Technique", result.getTitle());
        verify(resourceRepository, times(1)).save(any(Resource.class));
    }

    @Test
    void createResource_ShouldThrowException_WhenAdminNotFound() {
        when(userRepository.findById(adminId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> resourceService.createResource(createRequest, adminId));
        verify(resourceRepository, never()).save(any(Resource.class));
    }

    @Test
    void updateResource_ShouldModifyAndReturnDto_WhenResourceExists() {
        when(resourceRepository.findById(resource.getId())).thenReturn(Optional.of(resource));
        when(resourceRepository.save(any(Resource.class))).thenReturn(resource);
        when(resourceMapper.toDto(resource)).thenReturn(resourceDto);

        ResourceDto result = resourceService.updateResource(resource.getId(), updateRequest);

        assertNotNull(result);
        assertEquals("Two Pointers Technique (Updated)", resource.getTitle());
        verify(resourceRepository, times(1)).save(resource);
    }

    @Test
    void updateResource_ShouldThrowException_WhenResourceNotFound() {
        UUID unknownId = UUID.randomUUID();
        when(resourceRepository.findById(unknownId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> resourceService.updateResource(unknownId, updateRequest));
    }

    @Test
    void deleteResource_ShouldRemoveResource_WhenExists() {
        when(resourceRepository.findById(resource.getId())).thenReturn(Optional.of(resource));
        doNothing().when(resourceRepository).delete(resource);

        assertDoesNotThrow(() -> resourceService.deleteResource(resource.getId()));
        verify(resourceRepository, times(1)).delete(resource);
    }

    @Test
    void deleteResource_ShouldThrowException_WhenNotExists() {
        UUID unknownId = UUID.randomUUID();
        when(resourceRepository.findById(unknownId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> resourceService.deleteResource(unknownId));
    }

    @Test
    void getResourceById_ShouldReturnDto_WhenExists() {
        when(resourceRepository.findById(resource.getId())).thenReturn(Optional.of(resource));
        when(resourceMapper.toDto(resource)).thenReturn(resourceDto);

        ResourceDto result = resourceService.getResourceById(resource.getId());

        assertNotNull(result);
        assertEquals(resource.getId(), result.getId());
    }

    @Test
    void searchAndFilterResources_ShouldReturnPagedResults() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Resource> resourcePage = new PageImpl<>(List.of(resource));
        when(resourceRepository.searchAndFilterGlobal("pointers", null, pageable)).thenReturn(resourcePage);
        when(resourceMapper.toDto(resource)).thenReturn(resourceDto);

        Page<ResourceDto> result = resourceService.searchAndFilterResources("pointers", null, null, pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals("Two Pointers Technique", result.getContent().get(0).getTitle());
    }
}
