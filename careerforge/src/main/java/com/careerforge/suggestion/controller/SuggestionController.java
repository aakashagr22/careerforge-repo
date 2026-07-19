package com.careerforge.suggestion.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.security.UserPrincipal;
import com.careerforge.suggestion.dto.CreateSuggestionRequest;
import com.careerforge.suggestion.dto.ReplySuggestionRequest;
import com.careerforge.suggestion.dto.SuggestionDto;
import com.careerforge.suggestion.service.SuggestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "Suggestions", description = "APIs for student suggestions and admin feedback replies")
public class SuggestionController {

    private final SuggestionService suggestionService;

    // ======================== Student Endpoints ========================

    @PostMapping("/api/student/suggestions")
    @Operation(summary = "Submit a suggestion directly (Student)")
    public ResponseEntity<ApiResponse<SuggestionDto>> submitSuggestion(
            @Valid @RequestBody CreateSuggestionRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        SuggestionDto dto = suggestionService.submitSuggestion(request, principal.getId());
        return new ResponseEntity<>(ApiResponse.success(dto, "Suggestion submitted successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/api/student/suggestions")
    @Operation(summary = "Get list of own submitted suggestions (Student)")
    public ResponseEntity<ApiResponse<Page<SuggestionDto>>> getStudentSuggestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @AuthenticationPrincipal UserPrincipal principal) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SuggestionDto> suggestions = suggestionService.getStudentSuggestions(principal.getId(), pageable);
        return ResponseEntity.ok(ApiResponse.success(suggestions, "My suggestions retrieved successfully"));
    }

    // ======================== Admin Endpoints ========================

    @GetMapping("/api/admin/suggestions")
    @Operation(summary = "List all student suggestions (Admin)")
    public ResponseEntity<ApiResponse<Page<SuggestionDto>>> getAdminSuggestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SuggestionDto> suggestions = suggestionService.getAdminSuggestions(pageable);
        return ResponseEntity.ok(ApiResponse.success(suggestions, "All student suggestions retrieved successfully"));
    }

    @PostMapping("/api/admin/suggestions/{id}/reply")
    @Operation(summary = "Reply to a student suggestion (Admin)")
    public ResponseEntity<ApiResponse<SuggestionDto>> replyToSuggestion(
            @PathVariable UUID id,
            @Valid @RequestBody ReplySuggestionRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        SuggestionDto dto = suggestionService.replyToSuggestion(id, request, principal.getId());
        return ResponseEntity.ok(ApiResponse.success(dto, "Reply submitted successfully"));
    }
}
