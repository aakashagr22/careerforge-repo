package com.careerforge.suggestion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSuggestionRequest {

    @NotBlank(message = "Suggestion content is required")
    @Size(max = 2000, message = "Suggestion content cannot exceed 2000 characters")
    private String content;
}
