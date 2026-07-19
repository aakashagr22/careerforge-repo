package com.careerforge.suggestion;

import com.careerforge.suggestion.dto.CreateSuggestionRequest;
import com.careerforge.suggestion.dto.ReplySuggestionRequest;
import com.careerforge.suggestion.dto.SuggestionDto;
import com.careerforge.suggestion.entity.Suggestion;
import com.careerforge.suggestion.repository.SuggestionRepository;
import com.careerforge.suggestion.service.impl.SuggestionServiceImpl;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SuggestionServiceTest {

    @Mock
    private SuggestionRepository suggestionRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private SuggestionServiceImpl suggestionService;

    private User studentUser;
    private User adminUser;
    private Suggestion suggestion;

    @BeforeEach
    void setUp() {
        studentUser = User.builder()
                .id(UUID.randomUUID())
                .email("student@gmail.com")
                .firstName("Kushagra")
                .lastName("Trivedi")
                .build();

        adminUser = User.builder()
                .id(UUID.randomUUID())
                .email("admin@gmail.com")
                .firstName("Admin")
                .lastName("Forge")
                .build();

        suggestion = Suggestion.builder()
                .id(UUID.randomUUID())
                .student(studentUser)
                .content("Please add a dark mode calendar.")
                .build();
    }

    @Test
    void submitSuggestion_ShouldSucceed() {
        CreateSuggestionRequest request = CreateSuggestionRequest.builder()
                .content("Please add a dark mode calendar.")
                .build();

        when(userRepository.findById(studentUser.getId())).thenReturn(Optional.of(studentUser));
        when(suggestionRepository.countByStudentIdAndCreatedAtAfter(eq(studentUser.getId()), any(LocalDateTime.class))).thenReturn(0L);
        when(suggestionRepository.save(any(Suggestion.class))).thenAnswer(invocation -> {
            Suggestion saved = invocation.getArgument(0);
            saved.setId(UUID.randomUUID());
            saved.setCreatedAt(LocalDateTime.now());
            return saved;
        });

        SuggestionDto result = suggestionService.submitSuggestion(request, studentUser.getId());

        assertNotNull(result);
        assertEquals("Please add a dark mode calendar.", result.getContent());
        assertEquals("Kushagra Trivedi", result.getStudentName());
        assertNull(result.getReplyContent());
    }

    @Test
    void submitSuggestion_ShouldThrowException_WhenLimitReached() {
        CreateSuggestionRequest request = CreateSuggestionRequest.builder()
                .content("Please add a dark mode calendar.")
                .build();

        when(userRepository.findById(studentUser.getId())).thenReturn(Optional.of(studentUser));
        when(suggestionRepository.countByStudentIdAndCreatedAtAfter(eq(studentUser.getId()), any(LocalDateTime.class))).thenReturn(10L);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            suggestionService.submitSuggestion(request, studentUser.getId());
        });

        assertEquals("You have reached the maximum limit of 10 suggestions per year.", exception.getMessage());
        verify(suggestionRepository, never()).save(any(Suggestion.class));
    }

    @Test
    void getStudentSuggestions_ShouldReturnPaginatedList() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Suggestion> page = new PageImpl<>(Collections.singletonList(suggestion));

        when(suggestionRepository.findByStudentIdOrderByCreatedAtDesc(studentUser.getId(), pageable))
                .thenReturn(page);

        Page<SuggestionDto> result = suggestionService.getStudentSuggestions(studentUser.getId(), pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals("Please add a dark mode calendar.", result.getContent().get(0).getContent());
    }

    @Test
    void getAdminSuggestions_ShouldReturnPaginatedList() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Suggestion> page = new PageImpl<>(Collections.singletonList(suggestion));

        when(suggestionRepository.findAllByOrderByCreatedAtDesc(pageable))
                .thenReturn(page);

        Page<SuggestionDto> result = suggestionService.getAdminSuggestions(pageable);

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals("Please add a dark mode calendar.", result.getContent().get(0).getContent());
    }

    @Test
    void replyToSuggestion_ShouldSaveReplyAndRepliedAt() {
        ReplySuggestionRequest request = ReplySuggestionRequest.builder()
                .replyContent("Good suggestion. We will implement it soon.")
                .build();

        when(suggestionRepository.findById(suggestion.getId())).thenReturn(Optional.of(suggestion));
        when(userRepository.findById(adminUser.getId())).thenReturn(Optional.of(adminUser));
        when(suggestionRepository.save(any(Suggestion.class))).thenAnswer(invocation -> invocation.getArgument(0));

        SuggestionDto result = suggestionService.replyToSuggestion(suggestion.getId(), request, adminUser.getId());

        assertNotNull(result);
        assertEquals("Good suggestion. We will implement it soon.", result.getReplyContent());
        assertEquals("Admin Forge", result.getRepliedByName());
        assertNotNull(result.getRepliedAt());
    }
}
