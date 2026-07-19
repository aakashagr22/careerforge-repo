package com.careerforge.suggestion.service.impl;

import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.suggestion.dto.CreateSuggestionRequest;
import com.careerforge.suggestion.dto.ReplySuggestionRequest;
import com.careerforge.suggestion.dto.SuggestionDto;
import com.careerforge.suggestion.entity.Suggestion;
import com.careerforge.suggestion.repository.SuggestionRepository;
import com.careerforge.suggestion.service.SuggestionService;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public SuggestionDto submitSuggestion(CreateSuggestionRequest request, UUID studentId) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student user not found"));

        // Limit validation: Only 10 suggestions allowed per student per year
        LocalDateTime startOfYear = LocalDateTime.of(LocalDateTime.now().getYear(), 1, 1, 0, 0);
        long countThisYear = suggestionRepository.countByStudentIdAndCreatedAtAfter(studentId, startOfYear);
        if (countThisYear >= 10) {
            throw new IllegalArgumentException("You have reached the maximum limit of 10 suggestions per year.");
        }

        Suggestion suggestion = Suggestion.builder()
                .student(student)
                .content(request.getContent())
                .build();

        Suggestion saved = suggestionRepository.save(suggestion);
        log.info("Suggestion submitted successfully with ID: {} by user: {}", saved.getId(), studentId);
        return toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SuggestionDto> getStudentSuggestions(UUID studentId, Pageable pageable) {
        return suggestionRepository.findByStudentIdOrderByCreatedAtDesc(studentId, pageable)
                .map(this::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SuggestionDto> getAdminSuggestions(Pageable pageable) {
        return suggestionRepository.findAllByOrderByCreatedAtDesc(pageable)
                .map(this::toDto);
    }

    @Override
    @Transactional
    public SuggestionDto replyToSuggestion(UUID id, ReplySuggestionRequest request, UUID adminId) {
        Suggestion suggestion = suggestionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found"));

        User admin = userRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin user not found"));

        suggestion.setReplyContent(request.getReplyContent());
        suggestion.setRepliedBy(admin);
        suggestion.setRepliedAt(LocalDateTime.now());

        Suggestion saved = suggestionRepository.save(suggestion);
        log.info("Suggestion ID: {} replied to by admin ID: {}", saved.getId(), adminId);
        return toDto(saved);
    }

    private SuggestionDto toDto(Suggestion suggestion) {
        String studentName = "Anonymous User";
        UUID studentId = null;
        if (suggestion.getStudent() != null) {
            studentId = suggestion.getStudent().getId();
            studentName = suggestion.getStudent().getFirstName() + " " + suggestion.getStudent().getLastName();
        }

        String repliedByName = null;
        UUID repliedById = null;
        if (suggestion.getRepliedBy() != null) {
            repliedById = suggestion.getRepliedBy().getId();
            repliedByName = suggestion.getRepliedBy().getFirstName() + " " + suggestion.getRepliedBy().getLastName();
        }

        return SuggestionDto.builder()
                .id(suggestion.getId())
                .studentId(studentId)
                .studentName(studentName)
                .content(suggestion.getContent())
                .replyContent(suggestion.getReplyContent())
                .repliedById(repliedById)
                .repliedByName(repliedByName)
                .createdAt(suggestion.getCreatedAt())
                .repliedAt(suggestion.getRepliedAt())
                .build();
    }
}
