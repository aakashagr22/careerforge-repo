package com.careerforge.community.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.community.dto.*;
import com.careerforge.community.service.CommunityService;
import com.careerforge.security.UserPrincipal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student/questions")
public class CommunityController {
    private final CommunityService communityService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<CommunityQuestionDto>>> getQuestions(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(ApiResponse.success(communityService.getQuestions(PageRequest.of(page, Math.min(size, 50))), "Questions retrieved"));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CommunityQuestionDto>> getQuestion(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(communityService.getQuestion(id), "Question retrieved"));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<CommunityQuestionDto>> createQuestion(@Valid @RequestBody CreateQuestionRequest request, @AuthenticationPrincipal UserPrincipal principal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(communityService.createQuestion(request, principal.getId()), "Question posted"));
    }
    @PostMapping("/{id}/answers")
    public ResponseEntity<ApiResponse<CommunityAnswerDto>> createAnswer(@PathVariable UUID id, @Valid @RequestBody CreateAnswerRequest request, @AuthenticationPrincipal UserPrincipal principal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(communityService.createAnswer(id, request, principal.getId()), "Answer posted"));
    }
}
