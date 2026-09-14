package com.careerforge.chatbot.service.impl;

import com.careerforge.chatbot.client.GroqClient;
import com.careerforge.chatbot.dto.ChatMessageDto;
import com.careerforge.chatbot.dto.ChatbotQuotaDto;
import com.careerforge.chatbot.dto.ChatbotRequest;
import com.careerforge.chatbot.dto.ChatbotResponse;
import com.careerforge.chatbot.service.ChatbotKnowledgeBase;
import com.careerforge.chatbot.service.ChatbotRateLimiter;
import com.careerforge.chatbot.service.ChatbotService;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatbotServiceImpl implements ChatbotService {

    private final GroqClient groqClient;
    private final ChatbotRateLimiter rateLimiter;
    private final ChatbotKnowledgeBase knowledgeBase;
    private final StudentProfileRepository studentProfileRepository;
    private final com.careerforge.user.repository.UserRepository userRepository;

    @Value("${app.chatbot.daily-limit:20}")
    private int dailyLimit;

    @Override
    public ChatbotResponse askQuestion(UUID userId, ChatbotRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new com.careerforge.exception.ResourceNotFoundException("User not found with id: " + userId));

        // 1. Check rate limits & decrement student's daily quota
        int queriesRemaining = rateLimiter.recordAndCheckLimit(user);

        // 2. Fetch student context
        StudentProfile profile = studentProfileRepository.findByUserId(user.getId()).orElse(null);
        String roleStr = (profile != null && profile.getTargetRole() != null) ? profile.getTargetRole().name() : "SDE";
        String frameworkStr = (profile != null && profile.getFramework() != null) ? profile.getFramework() : "Spring Boot";
        int semester = (profile != null && profile.getSemester() != null) ? profile.getSemester() : 1;
        int streak = (profile != null && profile.getStreak() != null) ? profile.getStreak() : 0;

        // 3. Build system prompt with student context
        String systemPrompt = buildSystemPrompt(user.getFirstName(), roleStr, frameworkStr, semester, streak, request.getPageContext());

        // 4. Prune history to last 3 messages to optimize Groq tokens
        List<ChatMessageDto> messages = pruneHistory(request.getHistory(), request.getMessage());

        // 5. Try Groq with dual-key failover
        Optional<String> groqAnswer = groqClient.completeChat(systemPrompt, messages);

        if (groqAnswer.isPresent()) {
            return ChatbotResponse.builder()
                    .answer(groqAnswer.get())
                    .queriesRemaining(queriesRemaining)
                    .dailyLimit(dailyLimit)
                    .isOfflineKnowledge(false)
                    .suggestedFollowUps(generateFollowUps(request.getMessage(), roleStr, frameworkStr))
                    .relevantLinks(generateRelevantLinks(request.getMessage()))
                    .build();
        }

        // 6. Fallback to Local Knowledge Base if Groq is unconfigured or exhausted
        log.info("Groq API unavailable. Querying CareerForge local knowledge base for student [{}]", user.getEmail());
        Optional<ChatbotResponse> localAnswer = knowledgeBase.findAnswer(request.getMessage(), roleStr, frameworkStr, semester);

        if (localAnswer.isPresent()) {
            ChatbotResponse response = localAnswer.get();
            response.setQueriesRemaining(queriesRemaining);
            response.setDailyLimit(dailyLimit);
            return response;
        }

        // 7. General fallback response
        String fallbackAnswer = String.format("""
                ### 🤖 ForgeBot (Offline Guidance)
                
                I'm currently running on CareerForge's local platform knowledge engine.
                
                **Your Active Track:** %s with **%s** (Semester %d).
                
                - **Explore Learning Roadmaps**: Visit [/student/journey](/student/journey) for your semester-by-semester milestones.
                - **Practice Coding Sheets**: Visit [/student/sheets](/student/sheets) to practice curated DSA topics.
                - **Study Resources**: Visit [/student/resources](/student/resources) for notes, books, and interview preparation guides.
                - **Peer Community**: Visit [/student/community](/student/community) to post your question for peers and mentors.
                """, roleStr, frameworkStr, semester);

        return ChatbotResponse.builder()
                .answer(fallbackAnswer)
                .queriesRemaining(queriesRemaining)
                .dailyLimit(dailyLimit)
                .isOfflineKnowledge(true)
                .suggestedFollowUps(List.of(
                        "How to follow my journey milestones?",
                        "What are the best DSA practice sheets?",
                        "How to prepare for campus placement drives?"
                ))
                .relevantLinks(List.of(
                        ChatbotResponse.ChatbotResourceLinkDto.builder().title("My Journey").url("/student/journey").type("ROADMAP").build(),
                        ChatbotResponse.ChatbotResourceLinkDto.builder().title("Study Resources").url("/student/resources").type("RESOURCE").build()
                ))
                .build();
    }

    @Override
    public ChatbotQuotaDto getStudentQuota(UUID userId) {
        return rateLimiter.getQuota(userId);
    }

    @Override
    public List<String> getSuggestedPrompts(UUID userId) {
        StudentProfile profile = studentProfileRepository.findByUserId(userId).orElse(null);
        String framework = (profile != null && profile.getFramework() != null) ? profile.getFramework() : "Spring Boot";
        int semester = (profile != null && profile.getSemester() != null) ? profile.getSemester() : 1;

        return List.of(
                "How should I pace my Semester " + semester + " " + framework + " journey?",
                "What DSA patterns should I focus on for SDE interviews?",
                "Explain the difference between @Component and @Bean in Spring Boot",
                "How to prepare for System Design in campus placements?",
                "What resources are recommended for learning " + framework + "?"
        );
    }

    private String buildSystemPrompt(String name, String role, String framework, int semester, int streak, String pageContext) {
        return String.format("""
                You are ForgeBot, the expert AI Career & Technical Mentor built into the CareerForge education platform.

                STUDENT PROFILE:
                - Name: %s
                - Target Career Role: %s
                - Chosen Framework: %s
                - Current Academic Semester: %d
                - Study Streak: %d days
                - Current App Context: %s

                PLATFORM CAPABILITIES & NAVIGATION:
                - /student/journey: Personalized semester-by-semester learning milestones.
                - /student/sheets: Curated DSA practice sheets with topic-by-topic tracking.
                - /student/resources: Organized repository of notes, cheat sheets, and interview guides.
                - /student/community: Q&A forum to ask questions to peers.
                - /student/blogs: Placement interview experiences shared by seniors.
                - https://kernel-sable.vercel.app/signin: External coding contest platform.

                INSTRUCTIONS:
                1. Answer coding & technical questions (Java, Spring Boot, React, TypeScript, Python, DSA, System Design, SQL, Docker, etc.) accurately and concisely with markdown formatting and clean code blocks.
                2. If the student asks about how to follow their journey, roadmaps, or what to learn next, tailor your guidance specifically to their Target Role (%s), Framework (%s), and Semester (%d).
                3. Keep answers practical, actionable, and structured with bullet points. Avoid unnecessary fluff. Maximum length: ~400 words.
                """,
                (name != null ? name : "Student"), role, framework, semester, streak,
                (pageContext != null ? pageContext : "general"),
                role, framework, semester);
    }

    private List<ChatMessageDto> pruneHistory(List<ChatMessageDto> history, String currentMessage) {
        List<ChatMessageDto> pruned = new ArrayList<>();
        if (history != null && !history.isEmpty()) {
            int start = Math.max(0, history.size() - 3);
            for (int i = start; i < history.size(); i++) {
                ChatMessageDto msg = history.get(i);
                if (msg != null && msg.getContent() != null && !msg.getContent().isBlank()) {
                    pruned.add(msg);
                }
            }
        }
        pruned.add(ChatMessageDto.builder().role("user").content(currentMessage).build());
        return pruned;
    }

    private List<String> generateFollowUps(String query, String role, String framework) {
        String q = (query != null) ? query.toLowerCase() : "";
        if (q.contains("dsa") || q.contains("tree") || q.contains("graph")) {
            return List.of("Show me a code example for this pattern", "What are common edge cases?", "How to optimize time complexity?");
        } else if (q.contains("journey") || q.contains("semester")) {
            return List.of("What projects should I build this semester?", "How to balance DSA with " + framework + "?", "What resources should I review first?");
        } else {
            return List.of("Explain this with a code example", "What are common interview questions on this topic?", "How does this work under the hood?");
        }
    }

    private List<ChatbotResponse.ChatbotResourceLinkDto> generateRelevantLinks(String query) {
        String q = (query != null) ? query.toLowerCase() : "";
        List<ChatbotResponse.ChatbotResourceLinkDto> links = new ArrayList<>();

        if (q.contains("dsa") || q.contains("sheet") || q.contains("leetcode") || q.contains("problem")) {
            links.add(ChatbotResponse.ChatbotResourceLinkDto.builder().title("Practice Sheets").url("/student/sheets").type("SHEET").build());
            links.add(ChatbotResponse.ChatbotResourceLinkDto.builder().title("Contests").url("https://kernel-sable.vercel.app/signin").type("EXTERNAL").build());
        }
        if (q.contains("journey") || q.contains("roadmap") || q.contains("path") || q.contains("semester")) {
            links.add(ChatbotResponse.ChatbotResourceLinkDto.builder().title("My Journey").url("/student/journey").type("ROADMAP").build());
        }
        if (q.contains("resource") || q.contains("notes") || q.contains("book")) {
            links.add(ChatbotResponse.ChatbotResourceLinkDto.builder().title("Study Resources").url("/student/resources").type("RESOURCE").build());
        }
        return links;
    }
}
