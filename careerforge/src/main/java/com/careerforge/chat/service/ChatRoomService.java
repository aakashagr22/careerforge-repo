package com.careerforge.chat.service;

import com.careerforge.chat.dto.request.CreateRoomRequest;
import com.careerforge.chat.dto.request.MuteUserRequest;
import com.careerforge.chat.dto.request.UpdateRoomRequest;
import com.careerforge.chat.dto.response.ChatRoomResponse;
import com.careerforge.chat.dto.response.RoomStatisticsResponse;

import java.util.List;
import java.util.UUID;

public interface ChatRoomService {

    /**
     * Get all active rooms accessible by the given user (based on semester + role).
     */
    List<ChatRoomResponse> getAccessibleRooms(UUID userId);

    /**
     * Admin: Create a new chat room.
     */
    ChatRoomResponse createRoom(CreateRoomRequest request);

    /**
     * Admin: Update a room's name and/or description.
     */
    ChatRoomResponse updateRoom(UUID roomId, UpdateRoomRequest request);

    /**
     * Admin: Soft-delete (deactivate) a room.
     */
    void deleteRoom(UUID roomId);

    /**
     * Admin: Mute a user in a specific room.
     */
    void muteUser(UUID roomId, UUID userId, UUID adminId, MuteUserRequest request);

    /**
     * Admin: Unmute a user in a specific room.
     */
    void unmuteUser(UUID roomId, UUID userId);

    /**
     * Admin: Get statistics for a room.
     */
    RoomStatisticsResponse getRoomStatistics(UUID roomId);
}
