package com.careerforge.chat.service;

import com.careerforge.chat.dto.request.CreateConversationRequest;
import com.careerforge.chat.dto.response.PrivateConversationResponse;

import java.util.List;
import java.util.UUID;

public interface PrivateConversationService {

    /**
     * Create a private conversation between the current user and the target user.
     * If a conversation already exists, returns the existing one.
     */
    PrivateConversationResponse createConversation(UUID currentUserId, CreateConversationRequest request);

    /**
     * Get all private conversations for the current user.
     */
    List<PrivateConversationResponse> getConversations(UUID currentUserId);

    /**
     * Search users by name or email for starting a private conversation.
     */
    List<com.careerforge.chat.dto.response.UserSearchResponse> searchUsers(UUID currentUserId, String query);
}
