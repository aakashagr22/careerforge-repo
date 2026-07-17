package com.careerforge.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorResponse {
    @Builder.Default
    private boolean success = false;
    private String message;
    private Map<String, String> errors;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    public static ValidationErrorResponse of(String message, Map<String, String> errors) {
        return ValidationErrorResponse.builder()
                .message(message)
                .errors(errors)
                .build();
    }
}
