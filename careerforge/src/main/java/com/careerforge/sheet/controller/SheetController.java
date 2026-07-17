package com.careerforge.sheet.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.security.UserPrincipal;
import com.careerforge.sheet.dto.*;
import com.careerforge.sheet.service.SheetService;
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
@Tag(name = "Sheet & Progress Management", description = "APIs for coding sheets, topics and student progress tracking")
public class SheetController {

    private final SheetService sheetService;

    public SheetController(SheetService sheetService) {
        this.sheetService = sheetService;
    }

    // ======================== Admin Sheet CRUD ========================

    @PostMapping("/api/admin/sheets")
    @Operation(summary = "Create a new curriculum sheet (Admin)")
    public ResponseEntity<ApiResponse<SheetDto>> createSheet(@Valid @RequestBody CreateSheetRequest request) {
        SheetDto sheet = sheetService.createSheet(request);
        return new ResponseEntity<>(ApiResponse.success(sheet, "Sheet created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/sheets/{id}")
    @Operation(summary = "Update an existing curriculum sheet (Admin)")
    public ResponseEntity<ApiResponse<SheetDto>> updateSheet(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateSheetRequest request) {
        SheetDto sheet = sheetService.updateSheet(id, request);
        return ResponseEntity.ok(ApiResponse.success(sheet, "Sheet updated successfully"));
    }

    @DeleteMapping("/api/admin/sheets/{id}")
    @Operation(summary = "Delete a curriculum sheet (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteSheet(@PathVariable UUID id) {
        sheetService.deleteSheet(id);
        return ResponseEntity.ok(ApiResponse.success("Sheet deleted successfully"));
    }

    // ======================== Admin SheetTopic CRUD ========================

    @PostMapping("/api/admin/sheets/topics")
    @Operation(summary = "Create a new topic for a sheet (Admin)")
    public ResponseEntity<ApiResponse<SheetTopicDto>> createSheetTopic(@Valid @RequestBody CreateSheetTopicRequest request) {
        SheetTopicDto topic = sheetService.createSheetTopic(request);
        return new ResponseEntity<>(ApiResponse.success(topic, "Sheet topic created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/api/admin/sheets/topics/{id}")
    @Operation(summary = "Update an existing sheet topic (Admin)")
    public ResponseEntity<ApiResponse<SheetTopicDto>> updateSheetTopic(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateSheetTopicRequest request) {
        SheetTopicDto topic = sheetService.updateSheetTopic(id, request);
        return ResponseEntity.ok(ApiResponse.success(topic, "Sheet topic updated successfully"));
    }

    @DeleteMapping("/api/admin/sheets/topics/{id}")
    @Operation(summary = "Delete a sheet topic (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteSheetTopic(@PathVariable UUID id) {
        sheetService.deleteSheetTopic(id);
        return ResponseEntity.ok(ApiResponse.success("Sheet topic deleted successfully"));
    }

    // ======================== Student Endpoints ========================

    @GetMapping("/api/student/sheets")
    @Operation(summary = "Get paginated list of all sheets (Student)")
    public ResponseEntity<ApiResponse<Page<SheetDto>>> getSheets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SheetDto> sheets = sheetService.getAllSheets(pageable);
        return ResponseEntity.ok(ApiResponse.success(sheets, "Sheets retrieved successfully"));
    }

    @GetMapping("/api/student/sheets/{id}")
    @Operation(summary = "Get sheet details by ID (Student)")
    public ResponseEntity<ApiResponse<SheetDto>> getSheetById(@PathVariable UUID id) {
        SheetDto sheet = sheetService.getSheetById(id);
        return ResponseEntity.ok(ApiResponse.success(sheet, "Sheet details retrieved successfully"));
    }

    @GetMapping("/api/student/sheets/{id}/topics")
    @Operation(summary = "Get list of all topics within a sheet (Student)")
    public ResponseEntity<ApiResponse<List<SheetTopicDto>>> getTopicsBySheet(@PathVariable UUID id) {
        List<SheetTopicDto> topics = sheetService.getTopicsBySheetId(id);
        return ResponseEntity.ok(ApiResponse.success(topics, "Sheet topics retrieved successfully"));
    }

    @PostMapping("/api/student/sheets/topics/{topicId}/complete")
    @Operation(summary = "Mark a sheet topic as completed/incomplete (Student)")
    public ResponseEntity<ApiResponse<StudentSheetProgressDto>> markTopicCompleted(
            @PathVariable UUID topicId,
            @RequestParam(defaultValue = "true") boolean completed,
            @AuthenticationPrincipal UserPrincipal principal) {
        StudentSheetProgressDto progress = sheetService.markTopicCompleted(principal.getId(), topicId, completed);
        String message = completed ? "Topic marked as completed" : "Topic marked as incomplete";
        return ResponseEntity.ok(ApiResponse.success(progress, message));
    }

    @GetMapping("/api/student/sheets/{id}/progress")
    @Operation(summary = "Get student completion percentage progress for a sheet (Student)")
    public ResponseEntity<ApiResponse<Double>> getSheetProgress(
            @PathVariable UUID id,
            @AuthenticationPrincipal UserPrincipal principal) {
        double progress = sheetService.getProgressPercentage(principal.getId(), id);
        return ResponseEntity.ok(ApiResponse.success(progress, "Progress percentage retrieved successfully"));
    }

    @GetMapping("/api/student/sheets/completions")
    @Operation(summary = "Get list of all completed topic IDs for the current student (Student)")
    public ResponseEntity<ApiResponse<List<UUID>>> getCompletedTopicIds(
            @AuthenticationPrincipal UserPrincipal principal) {
        List<UUID> completedIds = sheetService.getCompletedTopicIds(principal.getId());
        return ResponseEntity.ok(ApiResponse.success(completedIds, "Completed topic IDs retrieved successfully"));
    }
}
