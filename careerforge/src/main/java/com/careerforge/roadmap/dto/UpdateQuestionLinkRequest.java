package com.careerforge.roadmap.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQuestionLinkRequest {

    @NotBlank(message = "Link type is required")
    private String linkType;

    private String label;

    @NotBlank(message = "URL is required")
    private String url;

    @NotNull(message = "Position is required")
    private Integer position;
}
