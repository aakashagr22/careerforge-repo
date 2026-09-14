package com.careerforge.chatbot.service;

import com.careerforge.chatbot.dto.ChatbotQuotaDto;
import com.careerforge.chatbot.dto.ChatbotRequest;
import com.careerforge.chatbot.dto.ChatbotResponse;

import java.util.List;
import java.util.UUID;

public interface ChatbotService {

    ChatbotResponse askQuestion(UUID userId, ChatbotRequest request);

    ChatbotQuotaDto getStudentQuota(UUID userId);

    List<String> getSuggestedPrompts(UUID userId);
}
