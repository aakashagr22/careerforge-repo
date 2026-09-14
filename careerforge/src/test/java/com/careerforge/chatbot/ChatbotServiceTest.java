package com.careerforge.chatbot;

import com.careerforge.chatbot.client.GroqClient;
import com.careerforge.chatbot.dto.ChatbotQuotaDto;
import com.careerforge.chatbot.dto.ChatbotRequest;
import com.careerforge.chatbot.dto.ChatbotResponse;
import com.careerforge.chatbot.service.ChatbotKnowledgeBase;
import com.careerforge.chatbot.service.ChatbotRateLimiter;
import com.careerforge.chatbot.service.impl.ChatbotServiceImpl;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.entity.TargetRole;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.entity.Role;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChatbotServiceTest {

    @Mock
    private GroqClient groqClient;

    @Mock
    private ChatbotRateLimiter rateLimiter;

    @Mock
    private ChatbotKnowledgeBase knowledgeBase;

    @Mock
    private StudentProfileRepository studentProfileRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ChatbotServiceImpl chatbotService;

    private User studentUser;
    private StudentProfile studentProfile;
    private UUID userId;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(chatbotService, "dailyLimit", 20);

        userId = UUID.randomUUID();
        studentUser = User.builder()
                .id(userId)
                .email("student@careerforge.com")
                .firstName("Aryan")
                .lastName("Sharma")
                .role(Role.STUDENT)
                .active(true)
                .build();

        studentProfile = StudentProfile.builder()
                .id(UUID.randomUUID())
                .user(studentUser)
                .targetRole(TargetRole.SDE)
                .framework("Spring Boot")
                .semester(3)
                .startingSemester(1)
                .streak(5)
                .build();
    }

    @Test
    void askQuestion_WithGroqSuccess_ReturnsGroqAnswer() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(studentUser));
        when(studentProfileRepository.findByUserId(userId)).thenReturn(Optional.of(studentProfile));
        when(rateLimiter.recordAndCheckLimit(studentUser)).thenReturn(19);
        when(groqClient.completeChat(anyString(), anyList()))
                .thenReturn(Optional.of("Spring Boot Dependency Injection works using the ApplicationContext and @Autowired."));

        ChatbotRequest request = ChatbotRequest.builder()
                .message("How does Dependency Injection work in Spring Boot?")
                .build();

        ChatbotResponse response = chatbotService.askQuestion(userId, request);

        assertNotNull(response);
        assertEquals("Spring Boot Dependency Injection works using the ApplicationContext and @Autowired.", response.getAnswer());
        assertEquals(19, response.getQueriesRemaining());
        assertEquals(20, response.getDailyLimit());
        assertFalse(response.isOfflineKnowledge());
        verify(groqClient).completeChat(anyString(), anyList());
        verify(knowledgeBase, never()).findAnswer(anyString(), anyString(), anyString(), anyInt());
    }

    @Test
    void askQuestion_WithGroqFailure_FallsBackToKnowledgeBase() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(studentUser));
        when(studentProfileRepository.findByUserId(userId)).thenReturn(Optional.of(studentProfile));
        when(rateLimiter.recordAndCheckLimit(studentUser)).thenReturn(15);
        when(groqClient.completeChat(anyString(), anyList())).thenReturn(Optional.empty());

        ChatbotResponse mockKbResponse = ChatbotResponse.builder()
                .answer("Semester 3 Milestone: Master Trees and Graphs alongside Spring Boot APIs.")
                .isOfflineKnowledge(true)
                .build();

        when(knowledgeBase.findAnswer(eq("How to follow my journey?"), anyString(), anyString(), anyInt()))
                .thenReturn(Optional.of(mockKbResponse));

        ChatbotRequest request = ChatbotRequest.builder()
                .message("How to follow my journey?")
                .build();

        ChatbotResponse response = chatbotService.askQuestion(userId, request);

        assertNotNull(response);
        assertTrue(response.isOfflineKnowledge());
        assertEquals(15, response.getQueriesRemaining());
        verify(knowledgeBase).findAnswer(eq("How to follow my journey?"), anyString(), anyString(), anyInt());
    }

    @Test
    void getStudentQuota_ReturnsCorrectData() {
        ChatbotQuotaDto mockQuota = ChatbotQuotaDto.builder()
                .dailyLimit(20)
                .queriesUsedToday(4)
                .queriesRemaining(16)
                .cooldownSecondsRemaining(0)
                .resetsAt(LocalDateTime.now().plusDays(1))
                .build();

        when(rateLimiter.getQuota(userId)).thenReturn(mockQuota);

        ChatbotQuotaDto result = chatbotService.getStudentQuota(userId);

        assertNotNull(result);
        assertEquals(20, result.getDailyLimit());
        assertEquals(16, result.getQueriesRemaining());
        assertEquals(4, result.getQueriesUsedToday());
    }

    @Test
    void getSuggestedPrompts_ReturnsTailoredPrompts() {
        when(studentProfileRepository.findByUserId(userId)).thenReturn(Optional.of(studentProfile));

        List<String> prompts = chatbotService.getSuggestedPrompts(userId);

        assertNotNull(prompts);
        assertFalse(prompts.isEmpty());
        assertTrue(prompts.stream().anyMatch(p -> p.contains("Spring Boot")));
    }
}
