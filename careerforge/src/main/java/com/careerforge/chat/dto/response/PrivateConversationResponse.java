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
public class PrivateConversationResponse {

    private UUID id;
    private UUID otherUserId;
    private String otherUserFirstName;
    private String otherUserLastName;
    private String otherUserEmail;
    private LocalDateTime createdAt;
}
