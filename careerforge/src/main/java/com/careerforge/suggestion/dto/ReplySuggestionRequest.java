package com.careerforge.suggestion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplySuggestionRequest {

    @NotBlank(message = "Reply content is required")
    @Size(max = 2000, message = "Reply content cannot exceed 2000 characters")
    private String replyContent;
}
