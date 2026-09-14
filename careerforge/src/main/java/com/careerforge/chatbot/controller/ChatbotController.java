package com.careerforge.chatbot.controller;

import com.careerforge.chatbot.dto.ChatbotQuotaDto;
import com.careerforge.chatbot.dto.ChatbotRequest;
import com.careerforge.chatbot.dto.ChatbotResponse;
import com.careerforge.chatbot.service.ChatbotService;
import com.careerforge.common.dto.ApiResponse;
import com.careerforge.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/chatbot")
@RequiredArgsConstructor
@Tag(name = "AI Chatbot", description = "AI Career & Tech Mentor endpoints for students")
public class ChatbotController {

    private final ChatbotService chatbotService;

    @PostMapping("/ask")
    @Operation(summary = "Ask AI Mentor", description = "Submit a tech question or journey query to ForgeBot")
    public ResponseEntity<ApiResponse<ChatbotResponse>> askQuestion(
            @AuthenticationPrincipal UserPrincipal principal,
            @Valid @RequestBody ChatbotRequest request) {
        ChatbotResponse response = chatbotService.askQuestion(principal.getId(), request);
        return ResponseEntity.ok(ApiResponse.success(response, "Response generated successfully"));
    }

    @GetMapping("/quota")
    @Operation(summary = "Get Chatbot Quota", description = "Returns student's daily remaining queries and cooldown status")
    public ResponseEntity<ApiResponse<ChatbotQuotaDto>> getQuota(
            @AuthenticationPrincipal UserPrincipal principal) {
        ChatbotQuotaDto quota = chatbotService.getStudentQuota(principal.getId());
        return ResponseEntity.ok(ApiResponse.success(quota, "Quota retrieved successfully"));
    }

    @GetMapping("/suggested-prompts")
    @Operation(summary = "Get Suggested Prompts", description = "Returns personalized question starters based on student journey")
    public ResponseEntity<ApiResponse<List<String>>> getSuggestedPrompts(
            @AuthenticationPrincipal UserPrincipal principal) {
        List<String> prompts = chatbotService.getSuggestedPrompts(principal.getId());
        return ResponseEntity.ok(ApiResponse.success(prompts, "Suggested prompts retrieved successfully"));
    }
}
