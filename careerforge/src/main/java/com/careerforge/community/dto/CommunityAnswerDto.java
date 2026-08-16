package com.careerforge.community.dto;

import lombok.Builder;
import lombok.Value;
import java.time.LocalDateTime;
import java.util.UUID;

@Value @Builder
public class CommunityAnswerDto {
    UUID id;
    UUID authorId;
    String authorName;
    String content;
    LocalDateTime createdAt;
}
