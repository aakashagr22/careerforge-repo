package com.careerforge.chat.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomStatisticsResponse {

    private UUID roomId;
    private String roomName;
    private String roomType;
    private long totalMembers;
    private long totalMessages;
    private long activeParticipants;
}
