package com.careerforge.resource.dto;

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
public class ResourceDto {
    private UUID id;
    private String title;
    private String description;
    private String category;
    private String type;
    private Difficulty difficulty;
    private String url;
    private String thumbnail;
    private UUID createdById;
    private String createdByName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
