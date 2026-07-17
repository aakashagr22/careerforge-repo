package com.careerforge.roadmap.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.roadmap.dto.*;
import com.careerforge.roadmap.service.RoadmapService;
import com.careerforge.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Roadmap Management", description = "APIs for creating and retrieving preparation roadmaps and phases")
public class RoadmapController {

    private final RoadmapService roadmapService;

    public RoadmapController(RoadmapService roadmapService) {
        this.roadmapService = roadmapService;
    }

    // ======================== Admin Roadmap CRUD ========================

    @PostMapping("/api/admin/roadmaps")
    @Operation(summary = "Create a new roadmap (Admin)")
    public ResponseEntity<ApiResponse<RoadmapDto>> createRoadmap(@Valid @RequestBody CreateRoadmapRequest request) {
        RoadmapDto roadmap = roadmapService.createRoadmap(request);
        return new ResponseEntity<>(ApiResponse.success(roadmap, "Roadmap created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/roadmaps/{id}")
    @Operation(summary = "Update an existing roadmap (Admin)")
    public ResponseEntity<ApiResponse<RoadmapDto>> updateRoadmap(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateRoadmapRequest request) {
        RoadmapDto roadmap = roadmapService.updateRoadmap(id, request);
        return ResponseEntity.ok(ApiResponse.success(roadmap, "Roadmap updated successfully"));
    }

    @DeleteMapping("/api/admin/roadmaps/{id}")
    @Operation(summary = "Delete a roadmap (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteRoadmap(@PathVariable UUID id) {
        roadmapService.deleteRoadmap(id);
        return ResponseEntity.ok(ApiResponse.success("Roadmap deleted successfully"));
    }

    @GetMapping("/api/admin/roadmaps")
    @Operation(summary = "Get paginated list of all roadmaps (Admin)")
    public ResponseEntity<ApiResponse<Page<RoadmapDto>>> getAllRoadmaps(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<RoadmapDto> roadmaps = roadmapService.getAllRoadmaps(pageable);
        return ResponseEntity.ok(ApiResponse.success(roadmaps, "Roadmaps retrieved successfully"));
    }

    @GetMapping("/api/admin/roadmaps/{id}")
    @Operation(summary = "Get roadmap by ID (Admin)")
    public ResponseEntity<ApiResponse<RoadmapDto>> getRoadmapById(@PathVariable UUID id) {
        RoadmapDto roadmap = roadmapService.getRoadmapById(id);
        return ResponseEntity.ok(ApiResponse.success(roadmap, "Roadmap details retrieved successfully"));
    }

    // ======================== Admin RoadmapPhase CRUD ========================

    @PostMapping("/api/admin/roadmaps/phases")
    @Operation(summary = "Create a roadmap phase (Admin)")
    public ResponseEntity<ApiResponse<RoadmapPhaseDto>> createRoadmapPhase(@Valid @RequestBody CreateRoadmapPhaseRequest request) {
        RoadmapPhaseDto phase = roadmapService.createRoadmapPhase(request);
        return new ResponseEntity<>(ApiResponse.success(phase, "Roadmap phase created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/roadmaps/phases/{id}")
    @Operation(summary = "Update an existing roadmap phase (Admin)")
    public ResponseEntity<ApiResponse<RoadmapPhaseDto>> updateRoadmapPhase(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateRoadmapPhaseRequest request) {
        RoadmapPhaseDto phase = roadmapService.updateRoadmapPhase(id, request);
        return ResponseEntity.ok(ApiResponse.success(phase, "Roadmap phase updated successfully"));
    }

    @DeleteMapping("/api/admin/roadmaps/phases/{id}")
    @Operation(summary = "Delete a roadmap phase (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteRoadmapPhase(@PathVariable UUID id) {
        roadmapService.deleteRoadmapPhase(id);
        return ResponseEntity.ok(ApiResponse.success("Roadmap phase deleted successfully"));
    }

    @GetMapping("/api/admin/roadmaps/phases/{id}")
    @Operation(summary = "Get roadmap phase by ID (Admin)")
    public ResponseEntity<ApiResponse<RoadmapPhaseDto>> getRoadmapPhaseById(@PathVariable UUID id) {
        RoadmapPhaseDto phase = roadmapService.getRoadmapPhaseById(id);
        return ResponseEntity.ok(ApiResponse.success(phase, "Roadmap phase retrieved successfully"));
    }

    @GetMapping("/api/admin/roadmaps/{roadmapId}/phases")
    @Operation(summary = "Get all phases of a specific roadmap (Admin)")
    public ResponseEntity<ApiResponse<List<RoadmapPhaseDto>>> getPhasesByRoadmap(@PathVariable UUID roadmapId) {
        List<RoadmapPhaseDto> phases = roadmapService.getPhasesByRoadmapId(roadmapId);
        return ResponseEntity.ok(ApiResponse.success(phases, "Roadmap phases retrieved successfully"));
    }

    // ======================== Student Endpoints ========================

    @GetMapping("/api/student/roadmap")
    @Operation(summary = "Get personalized roadmap (Student)")
    public ResponseEntity<ApiResponse<PersonalizedRoadmapResponse>> getPersonalizedRoadmap(
            @AuthenticationPrincipal UserPrincipal principal) {
        PersonalizedRoadmapResponse roadmapResponse = roadmapService.getPersonalizedRoadmap(principal.getId());
        return ResponseEntity.ok(ApiResponse.success(roadmapResponse, "Personalized roadmap retrieved successfully"));
    }
}
