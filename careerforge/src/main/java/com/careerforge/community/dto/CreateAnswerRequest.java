package com.careerforge.community.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAnswerRequest {
    @NotBlank @Size(max = 5000)
    private String content;
}
