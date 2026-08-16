package com.careerforge.community.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateQuestionRequest {
    @NotBlank @Size(max = 200)
    private String title;
    @NotBlank @Size(max = 5000)
    private String content;
    @Size(max = 500)
    private String tags;
}
