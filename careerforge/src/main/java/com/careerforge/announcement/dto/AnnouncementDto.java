package com.careerforge.announcement.dto;

import com.careerforge.announcement.entity.AnnouncementPriority;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnouncementDto {
    private UUID id;
    private String title;
    private String content;
    private AnnouncementPriority priority;
    private UUID createdById;
    private String createdByName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
