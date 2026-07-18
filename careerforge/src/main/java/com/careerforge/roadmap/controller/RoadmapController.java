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
@Tag(name = "Roadmap Management", description = "APIs for creating and retrieving preparation roadmaps, sections, and nested questions")
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

    // ======================== Admin RoadmapSection CRUD & Reorder ========================

    @PostMapping("/api/admin/roadmaps/sections")
    @Operation(summary = "Create a roadmap section (Admin)")
    public ResponseEntity<ApiResponse<RoadmapSectionTreeDto>> createSection(@Valid @RequestBody CreateRoadmapSectionRequest request) {
        RoadmapSectionTreeDto section = roadmapService.createSection(request);
        return new ResponseEntity<>(ApiResponse.success(section, "Roadmap section created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/roadmaps/sections/{id}")
    @Operation(summary = "Update/Move a roadmap section (Admin)")
    public ResponseEntity<ApiResponse<RoadmapSectionTreeDto>> updateSection(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateRoadmapSectionRequest request) {
        RoadmapSectionTreeDto section = roadmapService.updateSection(id, request);
        return ResponseEntity.ok(ApiResponse.success(section, "Roadmap section updated successfully"));
    }

    @DeleteMapping("/api/admin/roadmaps/sections/{id}")
    @Operation(summary = "Delete a roadmap section (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteSection(@PathVariable UUID id) {
        roadmapService.deleteSection(id);
        return ResponseEntity.ok(ApiResponse.success("Roadmap section deleted successfully"));
    }

    @GetMapping("/api/admin/roadmaps/{roadmapId}/tree")
    @Operation(summary = "Get full nested tree structure of a roadmap (Admin)")
    public ResponseEntity<ApiResponse<List<RoadmapSectionTreeDto>>> getSectionsTreeByRoadmap(@PathVariable UUID roadmapId) {
        List<RoadmapSectionTreeDto> tree = roadmapService.getSectionsTreeByRoadmapId(roadmapId);
        return ResponseEntity.ok(ApiResponse.success(tree, "Roadmap sections tree retrieved successfully"));
    }

    // ======================== Admin Questions CRUD ========================

    @PostMapping("/api/admin/questions")
    @Operation(summary = "Create a canonical question (Admin)")
    public ResponseEntity<ApiResponse<QuestionDto>> createQuestion(@Valid @RequestBody CreateQuestionRequest request) {
        QuestionDto question = roadmapService.createQuestion(request);
        return new ResponseEntity<>(ApiResponse.success(question, "Question created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/questions/{id}")
    @Operation(summary = "Update a canonical question (Admin)")
    public ResponseEntity<ApiResponse<QuestionDto>> updateQuestion(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateQuestionRequest request) {
        QuestionDto question = roadmapService.updateQuestion(id, request);
        return ResponseEntity.ok(ApiResponse.success(question, "Question updated successfully"));
    }

    @DeleteMapping("/api/admin/questions/{id}")
    @Operation(summary = "Delete a canonical question (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteQuestion(@PathVariable UUID id) {
        roadmapService.deleteQuestion(id);
        return ResponseEntity.ok(ApiResponse.success("Question deleted successfully"));
    }

    @GetMapping("/api/admin/questions")
    @Operation(summary = "Get list of all canonical questions (Admin)")
    public ResponseEntity<ApiResponse<List<QuestionDto>>> getAllQuestions() {
        List<QuestionDto> questions = roadmapService.getAllQuestions();
        return ResponseEntity.ok(ApiResponse.success(questions, "Questions retrieved successfully"));
    }

    // ======================== Admin QuestionLinks CRUD ========================

    @PostMapping("/api/admin/questions/{questionId}/links")
    @Operation(summary = "Add a link to a question (Admin)")
    public ResponseEntity<ApiResponse<QuestionLinkDto>> createQuestionLink(
            @PathVariable UUID questionId,
            @Valid @RequestBody CreateQuestionLinkRequest request) {
        QuestionLinkDto link = roadmapService.createQuestionLink(questionId, request);
        return new ResponseEntity<>(ApiResponse.success(link, "Question link created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/questions/links/{linkId}")
    @Operation(summary = "Update a question link (Admin)")
    public ResponseEntity<ApiResponse<QuestionLinkDto>> updateQuestionLink(
            @PathVariable UUID linkId,
            @Valid @RequestBody UpdateQuestionLinkRequest request) {
        QuestionLinkDto link = roadmapService.updateQuestionLink(linkId, request);
        return ResponseEntity.ok(ApiResponse.success(link, "Question link updated successfully"));
    }

    @DeleteMapping("/api/admin/questions/links/{linkId}")
    @Operation(summary = "Delete a question link (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteQuestionLink(@PathVariable UUID linkId) {
        roadmapService.deleteQuestionLink(linkId);
        return ResponseEntity.ok(ApiResponse.success("Question link deleted successfully"));
    }

    // ======================== Admin RoadmapSectionQuestion Placement ========================

    @PostMapping("/api/admin/roadmaps/sections/{sectionId}/question-items")
    @Operation(summary = "Assign a question row to a roadmap section (Admin)")
    public ResponseEntity<ApiResponse<RoadmapSectionQuestionDto>> assignQuestionToSection(
            @PathVariable UUID sectionId,
            @Valid @RequestBody AssignQuestionRequest request) {
        RoadmapSectionQuestionDto item = roadmapService.assignQuestionToSection(sectionId, request);
        return new ResponseEntity<>(ApiResponse.success(item, "Question assigned to section successfully"), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/roadmaps/sections/question-items/{sectionQuestionId}")
    @Operation(summary = "Remove a question mapping from a roadmap section (Admin)")
    public ResponseEntity<ApiResponse<Void>> removeQuestionFromSection(@PathVariable UUID sectionQuestionId) {
        roadmapService.removeQuestionFromSection(sectionQuestionId);
        return ResponseEntity.ok(ApiResponse.success("Question assignment removed successfully"));
    }

    // ======================== Student Endpoints ========================

    @GetMapping("/api/student/roadmap")
    @Operation(summary = "Get personalized nested roadmap tree with progress (Student)")
    public ResponseEntity<ApiResponse<PersonalizedRoadmapResponse>> getPersonalizedRoadmap(
            @AuthenticationPrincipal UserPrincipal principal) {
        PersonalizedRoadmapResponse roadmapResponse = roadmapService.getPersonalizedRoadmap(principal.getId());
        return ResponseEntity.ok(ApiResponse.success(roadmapResponse, "Personalized roadmap tree retrieved successfully"));
    }

    @PutMapping("/api/student/roadmap/question-items/{sectionQuestionId}/progress")
    @Operation(summary = "Track question completed, revision star, and notes (Student)")
    public ResponseEntity<ApiResponse<Void>> updateStudentQuestionProgress(
            @AuthenticationPrincipal UserPrincipal principal,
            @PathVariable UUID sectionQuestionId,
            @Valid @RequestBody UpdateStudentProgressRequest request) {
        roadmapService.updateStudentQuestionProgress(principal.getId(), sectionQuestionId, request);
        return ResponseEntity.ok(ApiResponse.success("Progress updated successfully"));
    }
}
