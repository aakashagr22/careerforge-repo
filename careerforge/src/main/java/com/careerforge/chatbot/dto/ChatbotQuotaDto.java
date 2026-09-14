package com.careerforge.chatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatbotQuotaDto {
    private int dailyLimit;
    private int queriesUsedToday;
    private int queriesRemaining;
    private int cooldownSecondsRemaining;
    private LocalDateTime resetsAt;
}
