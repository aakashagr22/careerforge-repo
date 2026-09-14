package com.careerforge.chatbot.service;

import com.careerforge.chatbot.dto.ChatbotQuotaDto;
import com.careerforge.chatbot.entity.ChatbotUsage;
import com.careerforge.chatbot.repository.ChatbotUsageRepository;
import com.careerforge.exception.BadRequestException;
import com.careerforge.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatbotRateLimiter {

    private final ChatbotUsageRepository usageRepository;

    @Value("${app.chatbot.daily-limit:20}")
    private int dailyLimit;

    @Value("${app.chatbot.cooldown-seconds:10}")
    private int cooldownSeconds;

    /**
     * Checks rate limits and records this query for the student.
     * Throws BadRequestException if daily quota is reached or cooldown has not passed.
     */
    @Transactional
    public int recordAndCheckLimit(User user) {
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();

        Optional<ChatbotUsage> usageOpt = usageRepository.findByUserIdAndUsageDate(user.getId(), today);
        ChatbotUsage usage;

        if (usageOpt.isPresent()) {
            usage = usageOpt.get();

            // 1. Check Cooldown
            long secondsSinceLastQuery = Duration.between(usage.getLastQueryAt(), now).getSeconds();
            if (secondsSinceLastQuery < cooldownSeconds) {
                long waitTime = cooldownSeconds - secondsSinceLastQuery;
                throw new BadRequestException("Please wait " + waitTime + " seconds before asking another question.");
            }

            // 2. Check Daily Limit
            if (usage.getQueryCount() >= dailyLimit) {
                throw new BadRequestException("You have reached your daily quota of " + dailyLimit + " AI queries. Quota resets at midnight!");
            }

            usage.setQueryCount(usage.getQueryCount() + 1);
            usage.setLastQueryAt(now);
        } else {
            usage = ChatbotUsage.builder()
                    .user(user)
                    .usageDate(today)
                    .queryCount(1)
                    .lastQueryAt(now)
                    .build();
        }

        usageRepository.save(usage);
        return Math.max(0, dailyLimit - usage.getQueryCount());
    }

    @Transactional(readOnly = true)
    public ChatbotQuotaDto getQuota(UUID userId) {
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();

        Optional<ChatbotUsage> usageOpt = usageRepository.findByUserIdAndUsageDate(userId, today);
        int queriesUsed = usageOpt.map(ChatbotUsage::getQueryCount).orElse(0);
        int remaining = Math.max(0, dailyLimit - queriesUsed);

        int cooldownRemaining = 0;
        if (usageOpt.isPresent()) {
            long secondsSince = Duration.between(usageOpt.get().getLastQueryAt(), now).getSeconds();
            if (secondsSince < cooldownSeconds) {
                cooldownRemaining = (int) (cooldownSeconds - secondsSince);
            }
        }

        LocalDateTime resetsAt = today.plusDays(1).atStartOfDay();

        return ChatbotQuotaDto.builder()
                .dailyLimit(dailyLimit)
                .queriesUsedToday(queriesUsed)
                .queriesRemaining(remaining)
                .cooldownSecondsRemaining(cooldownRemaining)
                .resetsAt(resetsAt)
                .build();
    }
}
