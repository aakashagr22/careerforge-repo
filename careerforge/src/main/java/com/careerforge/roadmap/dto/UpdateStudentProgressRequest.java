package com.careerforge.roadmap.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentProgressRequest {
    private Boolean completed;
    private Boolean revisionMarked;
    private String note;
}
