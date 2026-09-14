package com.careerforge.chatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatbotResponse {

    private String answer;
    private int queriesRemaining;
    private int dailyLimit;
    private boolean isOfflineKnowledge;
    private List<String> suggestedFollowUps;
    private List<ChatbotResourceLinkDto> relevantLinks;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChatbotResourceLinkDto {
        private String title;
        private String url;
        private String type; // "ROADMAP", "SHEET", "RESOURCE", "EXTERNAL"
    }
}
