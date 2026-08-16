package com.careerforge.community.service.impl;

import com.careerforge.community.dto.*;
import com.careerforge.community.entity.*;
import com.careerforge.community.repository.*;
import com.careerforge.community.service.CommunityService;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
    private final CommunityQuestionRepository questionRepository;
    private final CommunityAnswerRepository answerRepository;
    private final UserRepository userRepository;

    @Override @Transactional(readOnly = true)
    public Page<CommunityQuestionDto> getQuestions(Pageable pageable) {
        return questionRepository.findAllByOrderByCreatedAtDesc(pageable).map(question -> toQuestionDto(question, false));
    }

    @Override @Transactional(readOnly = true)
    public CommunityQuestionDto getQuestion(UUID questionId) {
        return toQuestionDto(findQuestion(questionId), true);
    }

    @Override @Transactional
    public CommunityQuestionDto createQuestion(CreateQuestionRequest request, UUID authorId) {
        User author = findUser(authorId);
        CommunityQuestion question = questionRepository.save(CommunityQuestion.builder()
                .author(author).title(request.getTitle().trim()).content(request.getContent().trim())
                .tags(normalizeTags(request.getTags())).build());
        return toQuestionDto(question, false);
    }

    @Override @Transactional
    public CommunityAnswerDto createAnswer(UUID questionId, CreateAnswerRequest request, UUID authorId) {
        CommunityAnswer answer = answerRepository.save(CommunityAnswer.builder()
                .question(findQuestion(questionId)).author(findUser(authorId)).content(request.getContent().trim()).build());
        return toAnswerDto(answer);
    }

    private CommunityQuestion findQuestion(UUID id) {
        return questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found"));
    }
    private User findUser(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    private CommunityQuestionDto toQuestionDto(CommunityQuestion question, boolean includeAnswers) {
        List<CommunityAnswerDto> answers = includeAnswers
                ? answerRepository.findByQuestionIdOrderByCreatedAtAsc(question.getId()).stream().map(this::toAnswerDto).toList()
                : List.of();
        return CommunityQuestionDto.builder().id(question.getId()).authorId(question.getAuthor().getId())
                .authorName(question.getAuthor().getFirstName() + " " + question.getAuthor().getLastName())
                .title(question.getTitle()).content(question.getContent()).tags(toTags(question.getTags()))
                .answerCount(includeAnswers ? answers.size() : answerRepository.countByQuestionId(question.getId()))
                .createdAt(question.getCreatedAt()).answers(answers).build();
    }
    private CommunityAnswerDto toAnswerDto(CommunityAnswer answer) {
        return CommunityAnswerDto.builder().id(answer.getId()).authorId(answer.getAuthor().getId())
                .authorName(answer.getAuthor().getFirstName() + " " + answer.getAuthor().getLastName())
                .content(answer.getContent()).createdAt(answer.getCreatedAt()).build();
    }
    private String normalizeTags(String tags) {
        if (tags == null || tags.isBlank()) return null;
        return String.join(",", toTags(tags));
    }
    private List<String> toTags(String tags) {
        if (tags == null || tags.isBlank()) return List.of();
        return Arrays.stream(tags.split(",")).map(String::trim).filter(tag -> !tag.isBlank()).distinct().limit(8).toList();
    }
}
