package com.careerforge.chat.service.impl;

import com.careerforge.chat.dto.request.CreateRoomRequest;
import com.careerforge.chat.dto.request.MuteUserRequest;
import com.careerforge.chat.dto.request.UpdateRoomRequest;
import com.careerforge.chat.dto.response.ChatRoomResponse;
import com.careerforge.chat.dto.response.RoomStatisticsResponse;
import com.careerforge.chat.entity.ChatRoom;
import com.careerforge.chat.entity.MutedUser;
import com.careerforge.chat.entity.RoomType;
import com.careerforge.chat.mapper.ChatMapper;
import com.careerforge.chat.repository.ChatMessageRepository;
import com.careerforge.chat.repository.ChatRoomRepository;
import com.careerforge.chat.repository.MutedUserRepository;
import com.careerforge.chat.repository.RoomMemberRepository;
import com.careerforge.chat.service.ChatRoomService;
import com.careerforge.chat.validator.ChatAccessValidator;
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
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final RoomMemberRepository roomMemberRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final MutedUserRepository mutedUserRepository;
    private final UserRepository userRepository;
    private final ChatMapper chatMapper;
    private final ChatAccessValidator chatAccessValidator;

    public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository,
                               RoomMemberRepository roomMemberRepository,
                               ChatMessageRepository chatMessageRepository,
                               MutedUserRepository mutedUserRepository,
                               UserRepository userRepository,
                               ChatMapper chatMapper,
                               ChatAccessValidator chatAccessValidator) {
        this.chatRoomRepository = chatRoomRepository;
        this.roomMemberRepository = roomMemberRepository;
        this.chatMessageRepository = chatMessageRepository;
        this.mutedUserRepository = mutedUserRepository;
        this.userRepository = userRepository;
        this.chatMapper = chatMapper;
        this.chatAccessValidator = chatAccessValidator;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChatRoomResponse> getAccessibleRooms(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        List<ChatRoom> allActiveRooms = chatRoomRepository.findByActiveTrue();

        return allActiveRooms.stream()
                .filter(room -> chatAccessValidator.canAccessRoom(user, room))
                .map(room -> {
                    ChatRoomResponse response = chatMapper.toRoomResponse(room);
                    response.setMemberCount(roomMemberRepository.countByChatRoomId(room.getId()));
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ChatRoomResponse createRoom(CreateRoomRequest request) {
        RoomType roomType;
        try {
            roomType = RoomType.valueOf(request.getRoomType());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid room type: " + request.getRoomType());
        }

        // Validate yearGroup is provided for YEAR_CHAT rooms
        if (roomType == RoomType.YEAR_CHAT && request.getYearGroup() == null) {
            throw new BadRequestException("Year group (1-4) is required for Year Chat rooms");
        }

        if (chatRoomRepository.existsByNameAndActiveTrue(request.getName())) {
            throw new BadRequestException("A room with the name '" + request.getName() + "' already exists");
        }

        ChatRoom chatRoom = ChatRoom.builder()
                .name(request.getName())
                .description(request.getDescription())
                .roomType(roomType)
                .yearGroup(roomType == RoomType.YEAR_CHAT ? request.getYearGroup() : null)
                .active(true)
                .build();

        ChatRoom savedRoom = chatRoomRepository.save(chatRoom);
        log.info("Created chat room: {} (type: {}, yearGroup: {})", savedRoom.getName(), savedRoom.getRoomType(), savedRoom.getYearGroup());

        ChatRoomResponse response = chatMapper.toRoomResponse(savedRoom);
        response.setMemberCount(0L);
        return response;
    }

    @Override
    public ChatRoomResponse updateRoom(UUID roomId, UpdateRoomRequest request) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat room not found with ID: " + roomId));

        // Check for name uniqueness if name is being changed
        if (!chatRoom.getName().equals(request.getName())
                && chatRoomRepository.existsByNameAndActiveTrue(request.getName())) {
            throw new BadRequestException("A room with the name '" + request.getName() + "' already exists");
        }

        chatRoom.setName(request.getName());
        chatRoom.setDescription(request.getDescription());

        ChatRoom updatedRoom = chatRoomRepository.save(chatRoom);
        log.info("Updated chat room: {}", updatedRoom.getName());

        ChatRoomResponse response = chatMapper.toRoomResponse(updatedRoom);
        response.setMemberCount(roomMemberRepository.countByChatRoomId(roomId));
        return response;
    }

    @Override
    public void deleteRoom(UUID roomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat room not found with ID: " + roomId));

        chatRoom.setActive(false);
        chatRoomRepository.save(chatRoom);
        log.info("Soft-deleted chat room: {} (ID: {})", chatRoom.getName(), roomId);
    }

    @Override
    public void muteUser(UUID roomId, UUID userId, UUID adminId, MuteUserRequest request) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat room not found with ID: " + roomId));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        User admin = userRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with ID: " + adminId));

        // Remove existing mute if present (to update it)
        mutedUserRepository.findByChatRoomIdAndUserId(roomId, userId)
                .ifPresent(existing -> mutedUserRepository.delete(existing));

        MutedUser mutedUser = MutedUser.builder()
                .chatRoom(chatRoom)
                .user(user)
                .mutedBy(admin)
                .reason(request.getReason())
                .expiresAt(request.getExpiresAt())
                .build();

        mutedUserRepository.save(mutedUser);
        log.info("Admin {} muted user {} in room {}", adminId, userId, roomId);
    }

    @Override
    @Transactional
    public void unmuteUser(UUID roomId, UUID userId) {
        if (mutedUserRepository.findByChatRoomIdAndUserId(roomId, userId).isEmpty()) {
            throw new ResourceNotFoundException("User is not muted in this room");
        }

        mutedUserRepository.deleteByChatRoomIdAndUserId(roomId, userId);
        log.info("Unmuted user {} in room {}", userId, roomId);
    }

    @Override
    @Transactional(readOnly = true)
    public RoomStatisticsResponse getRoomStatistics(UUID roomId) {
        ChatRoom chatRoom = chatRoomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat room not found with ID: " + roomId));

        long totalMembers = roomMemberRepository.countByChatRoomId(roomId);
        long totalMessages = chatMessageRepository.countByChatRoomIdAndDeletedFalse(roomId);
        long activeParticipants = chatMessageRepository.countDistinctSendersByChatRoomId(roomId);

        return RoomStatisticsResponse.builder()
                .roomId(chatRoom.getId())
                .roomName(chatRoom.getName())
                .roomType(chatRoom.getRoomType().name())
                .totalMembers(totalMembers)
                .totalMessages(totalMessages)
                .activeParticipants(activeParticipants)
                .build();
    }
}
