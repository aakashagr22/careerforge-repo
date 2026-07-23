package com.careerforge.chat.service.impl;

import com.careerforge.chat.dto.request.EditMessageRequest;
import com.careerforge.chat.dto.request.SendMessageRequest;
import com.careerforge.chat.dto.response.ChatMessageResponse;
import com.careerforge.chat.entity.*;
import com.careerforge.chat.mapper.ChatMapper;
import com.careerforge.chat.repository.ChatMessageRepository;
import com.careerforge.chat.repository.ChatRoomRepository;
import com.careerforge.chat.repository.MutedUserRepository;
import com.careerforge.chat.repository.PrivateConversationRepository;
import com.careerforge.chat.repository.RoomMemberRepository;
import com.careerforge.chat.service.ChatMessageService;
import com.careerforge.chat.validator.ChatAccessValidator;
import com.careerforge.exception.BadRequestException;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@Transactional
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final PrivateConversationRepository privateConversationRepository;
    private final RoomMemberRepository roomMemberRepository;
    private final MutedUserRepository mutedUserRepository;
    private final UserRepository userRepository;
    private final ChatMapper chatMapper;
    private final ChatAccessValidator chatAccessValidator;

    public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository,
                                  ChatRoomRepository chatRoomRepository,
                                  PrivateConversationRepository privateConversationRepository,
                                  RoomMemberRepository roomMemberRepository,
                                  MutedUserRepository mutedUserRepository,
                                  UserRepository userRepository,
                                  ChatMapper chatMapper,
                                  ChatAccessValidator chatAccessValidator) {
        this.chatMessageRepository = chatMessageRepository;
        this.chatRoomRepository = chatRoomRepository;
        this.privateConversationRepository = privateConversationRepository;
        this.roomMemberRepository = roomMemberRepository;
        this.mutedUserRepository = mutedUserRepository;
        this.userRepository = userRepository;
        this.chatMapper = chatMapper;
        this.chatAccessValidator = chatAccessValidator;
    }

    @Override
    public ChatMessageResponse sendMessage(UUID senderId, SendMessageRequest request) {
        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + senderId));

        // Validate exactly one target is set
        if ((request.getChatRoomId() == null) == (request.getConversationId() == null)) {
            throw new BadRequestException("Exactly one of chatRoomId or conversationId must be provided");
        }

        MessageType messageType = MessageType.TEXT;
        if (request.getMessageType() != null) {
            try {
                messageType = MessageType.valueOf(request.getMessageType());
            } catch (IllegalArgumentException e) {
                throw new BadRequestException("Invalid message type: " + request.getMessageType());
            }
        }

        ChatMessage.ChatMessageBuilder messageBuilder = ChatMessage.builder()
                .sender(sender)
                .message(request.getMessage())
                .messageType(messageType);

        if (request.getChatRoomId() != null) {
            ChatRoom chatRoom = chatRoomRepository.findById(request.getChatRoomId())
                    .orElseThrow(() -> new ResourceNotFoundException("Chat room not found with ID: " + request.getChatRoomId()));

            chatAccessValidator.validateRoomAccess(sender, chatRoom);

            // Check if user is muted
            if (mutedUserRepository.isUserMutedInRoom(chatRoom.getId(), senderId, LocalDateTime.now())) {
                throw new BadRequestException("You are muted in this chat room");
            }

            // Auto-enroll user as room member if not already enrolled
            if (!roomMemberRepository.existsByChatRoomIdAndUserId(chatRoom.getId(), senderId)) {
                RoomMember member = RoomMember.builder()
                        .chatRoom(chatRoom)
                        .user(sender)
                        .build();
                roomMemberRepository.save(member);
            }

            messageBuilder.chatRoom(chatRoom);
        } else {
            PrivateConversation conversation = privateConversationRepository.findById(request.getConversationId())
                    .orElseThrow(() -> new ResourceNotFoundException("Conversation not found with ID: " + request.getConversationId()));

            // Verify user is part of the conversation
            if (!conversation.getUserOne().getId().equals(senderId) &&
                    !conversation.getUserTwo().getId().equals(senderId)) {
                throw new BadRequestException("You are not a participant in this conversation");
            }

            messageBuilder.conversation(conversation);
        }

        ChatMessage savedMessage = chatMessageRepository.save(messageBuilder.build());
        log.debug("Message sent by user {} (target: {})", senderId,
                request.getChatRoomId() != null ? "room:" + request.getChatRoomId() : "conv:" + request.getConversationId());

        return chatMapper.toMessageResponse(savedMessage);
    }

    @Override
    public ChatMessageResponse editMessage(UUID userId, UUID messageId, EditMessageRequest request) {
        ChatMessage message = chatMessageRepository.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with ID: " + messageId));

        if (!message.getSender().getId().equals(userId)) {
            throw new BadRequestException("You can only edit your own messages");
        }

        if (message.isDeleted()) {
            throw new BadRequestException("Cannot edit a deleted message");
        }

        message.setMessage(request.getMessage());
        message.setEdited(true);
        message.setEditedAt(LocalDateTime.now());

        ChatMessage updatedMessage = chatMessageRepository.save(message);
        log.debug("Message {} edited by user {}", messageId, userId);

        return chatMapper.toMessageResponse(updatedMessage);
    }

    @Override
    public void deleteMessage(UUID userId, UUID messageId) {
        ChatMessage message = chatMessageRepository.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with ID: " + messageId));

        if (!message.getSender().getId().equals(userId)) {
            throw new BadRequestException("You can only delete your own messages");
        }

        message.setDeleted(true);
        chatMessageRepository.save(message);
        log.debug("Message {} soft-deleted by user {}", messageId, userId);
    }

    @Override
    public void adminDeleteMessage(UUID messageId) {
        ChatMessage message = chatMessageRepository.findById(messageId)
                .orElseThrow(() -> new ResourceNotFoundException("Message not found with ID: " + messageId));

        chatMessageRepository.delete(message);
        log.info("Message {} hard-deleted by admin", messageId);
    }

    @Override
    public Page<ChatMessageResponse> getRoomMessages(UUID userId, UUID roomId, Pageable pageable) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat room not found with ID: " + roomId));

        chatAccessValidator.validateRoomAccess(user, chatRoom);

        // Auto-enroll user as room member when viewing room feed
        if (!roomMemberRepository.existsByChatRoomIdAndUserId(roomId, userId)) {
            RoomMember member = RoomMember.builder()
                    .chatRoom(chatRoom)
                    .user(user)
                    .build();
            roomMemberRepository.save(member);
        }

        return chatMessageRepository.findByChatRoomIdAndDeletedFalseOrderByCreatedAtDesc(roomId, pageable)
                .map(chatMapper::toMessageResponse);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ChatMessageResponse> getConversationMessages(UUID userId, UUID conversationId, Pageable pageable) {
        PrivateConversation conversation = privateConversationRepository.findById(conversationId)
                .orElseThrow(() -> new ResourceNotFoundException("Conversation not found with ID: " + conversationId));

        if (!conversation.getUserOne().getId().equals(userId) &&
                !conversation.getUserTwo().getId().equals(userId)) {
            throw new BadRequestException("You are not a participant in this conversation");
        }

        return chatMessageRepository.findByConversationIdAndDeletedFalseOrderByCreatedAtDesc(conversationId, pageable)
                .map(chatMapper::toMessageResponse);
    }
}
