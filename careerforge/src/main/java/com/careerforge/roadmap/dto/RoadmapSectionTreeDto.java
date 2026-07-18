package com.careerforge.roadmap.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoadmapSectionTreeDto {
    private UUID id;
    private String title;
    private Integer position;
    
    @Builder.Default
    private List<RoadmapSectionTreeDto> children = new ArrayList<>();
    
    @Builder.Default
    private List<RoadmapSectionQuestionDto> questions = new ArrayList<>();
}
