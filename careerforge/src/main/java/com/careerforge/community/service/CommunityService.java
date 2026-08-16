package com.careerforge.community.service;

import com.careerforge.community.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.UUID;

public interface CommunityService {
    Page<CommunityQuestionDto> getQuestions(Pageable pageable);
    CommunityQuestionDto getQuestion(UUID questionId);
    CommunityQuestionDto createQuestion(CreateQuestionRequest request, UUID authorId);
    CommunityAnswerDto createAnswer(UUID questionId, CreateAnswerRequest request, UUID authorId);
}
