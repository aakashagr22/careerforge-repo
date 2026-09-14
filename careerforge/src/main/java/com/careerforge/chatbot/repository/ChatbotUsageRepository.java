package com.careerforge.chatbot.repository;

import com.careerforge.chatbot.entity.ChatbotUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChatbotUsageRepository extends JpaRepository<ChatbotUsage, UUID> {

    Optional<ChatbotUsage> findByUserIdAndUsageDate(UUID userId, LocalDate usageDate);
}
