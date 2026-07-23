package com.careerforge.chat.service.impl;

import com.careerforge.chat.dto.request.CreateConversationRequest;
import com.careerforge.chat.dto.response.PrivateConversationResponse;
import com.careerforge.chat.dto.response.UserSearchResponse;
import com.careerforge.chat.entity.PrivateConversation;
import com.careerforge.chat.repository.PrivateConversationRepository;
import com.careerforge.chat.service.PrivateConversationService;
import com.careerforge.exception.BadRequestException;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class PrivateConversationServiceImpl implements PrivateConversationService {

    private final PrivateConversationRepository privateConversationRepository;
    private final UserRepository userRepository;

    public PrivateConversationServiceImpl(PrivateConversationRepository privateConversationRepository,
                                          UserRepository userRepository) {
        this.privateConversationRepository = privateConversationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PrivateConversationResponse createConversation(UUID currentUserId, CreateConversationRequest request) {
        if (currentUserId.equals(request.getTargetUserId())) {
            throw new BadRequestException("Cannot create a conversation with yourself");
        }

        User currentUser = userRepository.findById(currentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + currentUserId));

        User targetUser = userRepository.findById(request.getTargetUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Target user not found with ID: " + request.getTargetUserId()));

        // Check if conversation already exists (bidirectional)
        return privateConversationRepository.findByUserPair(currentUserId, request.getTargetUserId())
                .map(existing -> toResponse(existing, currentUserId))
                .orElseGet(() -> {
                    // Ensure consistent ordering: lower UUID is always userOne
                    User userOne = currentUserId.compareTo(request.getTargetUserId()) < 0 ? currentUser : targetUser;
                    User userTwo = currentUserId.compareTo(request.getTargetUserId()) < 0 ? targetUser : currentUser;

                    PrivateConversation conversation = PrivateConversation.builder()
                            .userOne(userOne)
                            .userTwo(userTwo)
                            .build();

                    PrivateConversation saved = privateConversationRepository.save(conversation);
                    log.info("Created private conversation between users {} and {}", currentUserId, request.getTargetUserId());

                    return toResponse(saved, currentUserId);
                });
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrivateConversationResponse> getConversations(UUID currentUserId) {
        return privateConversationRepository.findAllByUserId(currentUserId)
                .stream()
                .map(conv -> toResponse(conv, currentUserId))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserSearchResponse> searchUsers(UUID currentUserId, String query) {
        if (query == null || query.trim().length() < 2) {
            throw new BadRequestException("Search query must be at least 2 characters");
        }

        String searchTerm = query.trim().toLowerCase();

        // Search across all active users by name or email (excluding current user)
        return userRepository.findAll().stream()
                .filter(user -> user.isActive() && !user.getId().equals(currentUserId))
                .filter(user ->
                        user.getFirstName().toLowerCase().contains(searchTerm) ||
                        user.getLastName().toLowerCase().contains(searchTerm) ||
                        user.getEmail().toLowerCase().contains(searchTerm))
                .limit(20) // Limit results
                .map(user -> UserSearchResponse.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * Maps a PrivateConversation to a response, showing the "other" user
     * relative to the requesting user.
     */
    private PrivateConversationResponse toResponse(PrivateConversation conversation, UUID currentUserId) {
        User otherUser = conversation.getUserOne().getId().equals(currentUserId)
                ? conversation.getUserTwo()
                : conversation.getUserOne();

        return PrivateConversationResponse.builder()
                .id(conversation.getId())
                .otherUserId(otherUser.getId())
                .otherUserFirstName(otherUser.getFirstName())
                .otherUserLastName(otherUser.getLastName())
                .otherUserEmail(otherUser.getEmail())
                .createdAt(conversation.getCreatedAt())
                .build();
    }
}
