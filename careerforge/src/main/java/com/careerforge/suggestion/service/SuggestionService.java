package com.careerforge.suggestion.service;

import com.careerforge.suggestion.dto.CreateSuggestionRequest;
import com.careerforge.suggestion.dto.ReplySuggestionRequest;
import com.careerforge.suggestion.dto.SuggestionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface SuggestionService {

    SuggestionDto submitSuggestion(CreateSuggestionRequest request, UUID studentId);

    Page<SuggestionDto> getStudentSuggestions(UUID studentId, Pageable pageable);

    Page<SuggestionDto> getAdminSuggestions(Pageable pageable);

    SuggestionDto replyToSuggestion(UUID id, ReplySuggestionRequest request, UUID adminId);
}
