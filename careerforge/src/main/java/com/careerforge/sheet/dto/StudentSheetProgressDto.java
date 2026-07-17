package com.careerforge.sheet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSheetProgressDto {
    private UUID id;
    private UUID studentId;
    private UUID sheetTopicId;
    private boolean completed;
    private LocalDateTime completedAt;
}
