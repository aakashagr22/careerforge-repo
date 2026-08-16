package com.careerforge.community.dto;

import lombok.Builder;
import lombok.Value;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Value @Builder
public class CommunityQuestionDto {
    UUID id;
    UUID authorId;
    String authorName;
    String title;
    String content;
    List<String> tags;
    long answerCount;
    LocalDateTime createdAt;
    List<CommunityAnswerDto> answers;
}
