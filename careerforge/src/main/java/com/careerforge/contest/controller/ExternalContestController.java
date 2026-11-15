package com.careerforge.contest.controller;

import com.careerforge.common.dto.ApiResponse;
import com.careerforge.contest.service.KernelContestService;
import com.careerforge.security.UserPrincipal;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/contests")
@Tag(name = "Contests Integration", description = "Endpoints for Kernel coding contests and leaderboards")
public class ExternalContestController {

    private final KernelContestService contestService;

    public ExternalContestController(KernelContestService contestService) {
        this.contestService = contestService;
    }

    @GetMapping
    @Operation(summary = "Get all contests (live, upcoming, concluded)")
    public ResponseEntity<ApiResponse<JsonNode>> getAllContests(
            @RequestParam(required = false, defaultValue = "all") String status) {
        JsonNode contests = contestService.getContests(status);
        return ResponseEntity.ok(ApiResponse.success(contests, "Contests retrieved successfully"));
    }

    @GetMapping("/{code}/leaderboard")
    @Operation(summary = "Get contest leaderboard by code")
    public ResponseEntity<ApiResponse<JsonNode>> getLeaderboard(
            @PathVariable String code) {
        JsonNode leaderboard = contestService.getLeaderboard(code);
        return ResponseEntity.ok(ApiResponse.success(leaderboard, "Leaderboard retrieved successfully"));
    }

    @GetMapping("/my-history")
    @Operation(summary = "Get current authenticated student's contest participation and scorecards")
    public ResponseEntity<ApiResponse<JsonNode>> getMyContestHistory(
            @AuthenticationPrincipal UserPrincipal principal) {
        JsonNode history = contestService.getStudentContests(principal.getEmail());
        return ResponseEntity.ok(ApiResponse.success(history, "Student contest history retrieved successfully"));
    }
}
