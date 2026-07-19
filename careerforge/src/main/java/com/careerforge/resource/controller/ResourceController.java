package com.careerforge.resource.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.resource.dto.CreateResourceRequest;
import com.careerforge.resource.dto.ResourceDto;
import com.careerforge.resource.dto.UpdateResourceRequest;
import com.careerforge.resource.service.ResourceService;
import com.careerforge.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Resources", description = "APIs for managing placement preparation resources")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    // ======================== Admin Endpoints ========================

    @PostMapping("/api/admin/resources")
    @Operation(summary = "Create a new resource (Admin)")
    public ResponseEntity<ApiResponse<ResourceDto>> createResource(
            @Valid @RequestBody CreateResourceRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        ResourceDto resource = resourceService.createResource(request, principal.getId());
        return new ResponseEntity<>(ApiResponse.success(resource, "Resource created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/resources/{id}")
    @Operation(summary = "Update an existing resource (Admin)")
    public ResponseEntity<ApiResponse<ResourceDto>> updateResource(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateResourceRequest request) {
        ResourceDto resource = resourceService.updateResource(id, request);
        return ResponseEntity.ok(ApiResponse.success(resource, "Resource updated successfully"));
    }

    @DeleteMapping("/api/admin/resources/{id}")
    @Operation(summary = "Delete a resource (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteResource(@PathVariable UUID id) {
        resourceService.deleteResource(id);
        return ResponseEntity.ok(ApiResponse.success("Resource deleted successfully"));
    }

    // ======================== Student Endpoints ========================

    @GetMapping("/api/student/resources")
    @Operation(summary = "Search and filter resources with pagination (Student)")
    public ResponseEntity<ApiResponse<Page<ResourceDto>>> getResources(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) UUID folderId,
            @RequestParam(required = false) com.careerforge.resource.entity.ResourceType type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<ResourceDto> resources = resourceService.searchAndFilterResources(query, folderId, type, pageable);
        return ResponseEntity.ok(ApiResponse.success(resources, "Resources retrieved successfully"));
    }

    @GetMapping("/api/student/resources/{id}")
    @Operation(summary = "Get a specific resource by ID (Student)")
    public ResponseEntity<ApiResponse<ResourceDto>> getResourceById(@PathVariable UUID id) {
        ResourceDto resource = resourceService.getResourceById(id);
        return ResponseEntity.ok(ApiResponse.success(resource, "Resource retrieved successfully"));
    }
}
