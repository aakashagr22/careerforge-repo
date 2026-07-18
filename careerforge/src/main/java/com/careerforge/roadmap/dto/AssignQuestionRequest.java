package com.careerforge.roadmap.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignQuestionRequest {

    @NotNull(message = "Question ID is required")
    private UUID questionId;

    @NotNull(message = "Position is required")
    private Integer position;
}
