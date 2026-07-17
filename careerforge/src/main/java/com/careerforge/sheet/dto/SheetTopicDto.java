package com.careerforge.sheet.dto;

import com.careerforge.common.entity.Difficulty;
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
public class SheetTopicDto {
    private UUID id;
    private String title;
    private String description;
    private Difficulty difficulty;
    private Integer orderIndex;
    private UUID sheetId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
