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
public class ChatMessageResponse {

    private UUID id;
    private UUID chatRoomId;
    private UUID conversationId;
    private UUID senderId;
    private String senderFirstName;
    private String senderLastName;
    private String senderEmail;
    private String message;
    private String messageType;
    private boolean edited;
    private LocalDateTime editedAt;
    private boolean deleted;
    private LocalDateTime createdAt;
}
