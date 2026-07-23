package com.careerforge.chat.dto.response;

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
public class ChatRoomResponse {

    private UUID id;
    private String name;
    private String description;
    private String roomType;
    private Integer yearGroup;
    private boolean active;
    private long memberCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
