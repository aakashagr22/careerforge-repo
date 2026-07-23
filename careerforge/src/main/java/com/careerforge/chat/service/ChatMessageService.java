package com.careerforge.chat.service;

import com.careerforge.chat.dto.request.EditMessageRequest;
import com.careerforge.chat.dto.request.SendMessageRequest;
import com.careerforge.chat.dto.response.ChatMessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ChatMessageService {

    /**
     * Send a message to a room or private conversation.
     */
    ChatMessageResponse sendMessage(UUID senderId, SendMessageRequest request);

    /**
     * Edit a message (only the sender can edit their own messages).
     */
    ChatMessageResponse editMessage(UUID userId, UUID messageId, EditMessageRequest request);

    /**
     * Soft-delete a message (only the sender can delete their own messages).
     */
    void deleteMessage(UUID userId, UUID messageId);

    /**
     * Admin: Hard-delete any message.
     */
    void adminDeleteMessage(UUID messageId);

    /**
     * Get paginated messages for a room.
     */
    Page<ChatMessageResponse> getRoomMessages(UUID userId, UUID roomId, Pageable pageable);

    /**
     * Get paginated messages for a private conversation.
     */
    Page<ChatMessageResponse> getConversationMessages(UUID userId, UUID conversationId, Pageable pageable);
}
