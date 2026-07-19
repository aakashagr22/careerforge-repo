package com.careerforge.suggestion.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuggestionDto {
    private UUID id;
    private UUID studentId;
    private String studentName;
    private String content;
    private String replyContent;
    private UUID repliedById;
    private String repliedByName;
    private LocalDateTime createdAt;
    private LocalDateTime repliedAt;
}
