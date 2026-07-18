package com.careerforge.roadmap.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapSectionQuestionDto {
    private UUID sectionQuestionId; // placement id
    private UUID questionId; // canonical id
    private String title;
    private String description;
    private String difficulty;
    private Integer position;
    private List<QuestionLinkDto> links;
    
    // Student context specific progress fields
    private Boolean completed;
    private Boolean revisionMarked;
    private String note;
}
