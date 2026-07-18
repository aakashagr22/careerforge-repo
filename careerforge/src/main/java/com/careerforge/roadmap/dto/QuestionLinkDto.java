package com.careerforge.roadmap.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionLinkDto {
    private UUID id;
    private String linkType;
    private String label;
    private String url;
    private Integer position;
}
