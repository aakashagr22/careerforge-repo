package com.careerforge.resource.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.resource.dto.*;
import com.careerforge.resource.entity.ResourceType;
import com.careerforge.resource.service.ResourceFolderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Tag(name = "Resource Folders", description = "APIs for managing hierarchical resource folders")
public class ResourceFolderController {

    private final ResourceFolderService resourceFolderService;

    public ResourceFolderController(ResourceFolderService resourceFolderService) {
        this.resourceFolderService = resourceFolderService;
    }

    // ======================== Admin Endpoints ========================

    @PostMapping("/api/admin/resource-folders")
    @Operation(summary = "Create a new resource folder (Admin)")
    public ResponseEntity<ApiResponse<FolderDto>> createFolder(@Valid @RequestBody CreateFolderRequest request) {
        FolderDto folder = resourceFolderService.createFolder(request);
        return new ResponseEntity<>(ApiResponse.success(folder, "Folder created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/resource-folders/{id}")
    @Operation(summary = "Update or move an existing resource folder (Admin)")
    public ResponseEntity<ApiResponse<FolderDto>> updateFolder(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateFolderRequest request) {
        FolderDto folder = resourceFolderService.updateFolder(id, request);
        return ResponseEntity.ok(ApiResponse.success(folder, "Folder updated successfully"));
    }

    @DeleteMapping("/api/admin/resource-folders/{id}")
    @Operation(summary = "Delete an empty resource folder (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteFolder(@PathVariable UUID id) {
        resourceFolderService.deleteFolder(id);
        return ResponseEntity.ok(ApiResponse.success("Folder deleted successfully"));
    }

    @GetMapping("/api/admin/resource-folders/root")
    @Operation(summary = "Get admin root directory (Admin)")
    public ResponseEntity<ApiResponse<FolderDirectoryDto>> getAdminRootDirectory(
            @RequestParam(required = false) ResourceType type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        FolderDirectoryDto directory = resourceFolderService.getFolderDirectory(null, type, pageable);
        return ResponseEntity.ok(ApiResponse.success(directory, "Root directory retrieved successfully"));
    }

    @GetMapping("/api/admin/resource-folders/{id}")
    @Operation(summary = "Get admin folder directory (Admin)")
    public ResponseEntity<ApiResponse<FolderDirectoryDto>> getAdminFolderDirectory(
            @PathVariable UUID id,
            @RequestParam(required = false) ResourceType type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        FolderDirectoryDto directory = resourceFolderService.getFolderDirectory(id, type, pageable);
        return ResponseEntity.ok(ApiResponse.success(directory, "Folder directory retrieved successfully"));
    }

    // ======================== Student Endpoints ========================

    @GetMapping("/api/student/resource-folders/root")
    @Operation(summary = "Get student root directory (Student)")
    public ResponseEntity<ApiResponse<FolderDirectoryDto>> getStudentRootDirectory(
            @RequestParam(required = false) ResourceType type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        FolderDirectoryDto directory = resourceFolderService.getFolderDirectory(null, type, pageable);
        return ResponseEntity.ok(ApiResponse.success(directory, "Root directory retrieved successfully"));
    }

    @GetMapping("/api/student/resource-folders/{id}")
    @Operation(summary = "Get student folder directory (Student)")
    public ResponseEntity<ApiResponse<FolderDirectoryDto>> getStudentFolderDirectory(
            @PathVariable UUID id,
            @RequestParam(required = false) ResourceType type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        FolderDirectoryDto directory = resourceFolderService.getFolderDirectory(id, type, pageable);
        return ResponseEntity.ok(ApiResponse.success(directory, "Folder directory retrieved successfully"));
    }
}
