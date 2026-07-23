package com.careerforge.chat.controller;

import com.careerforge.chat.dto.request.CreateRoomRequest;
import com.careerforge.chat.dto.request.MuteUserRequest;
import com.careerforge.chat.dto.request.UpdateRoomRequest;
import com.careerforge.chat.dto.response.ChatRoomResponse;
import com.careerforge.chat.dto.response.RoomStatisticsResponse;
import com.careerforge.chat.service.ChatMessageService;
import com.careerforge.chat.service.ChatRoomService;
import com.careerforge.common.dto.ApiResponse;
import com.careerforge.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin/chat")
@Tag(name = "Admin Chat Management", description = "Chat administration APIs for admins")
public class ChatAdminController {

    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    public ChatAdminController(ChatRoomService chatRoomService,
                                ChatMessageService chatMessageService) {
        this.chatRoomService = chatRoomService;
        this.chatMessageService = chatMessageService;
    }

    // ===================== ROOMS =====================

    @PostMapping("/rooms")
    @Operation(summary = "Create chat room", description = "Create a new public chat room")
    public ResponseEntity<ApiResponse<ChatRoomResponse>> createRoom(
            @Valid @RequestBody CreateRoomRequest request) {
        ChatRoomResponse response = chatRoomService.createRoom(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Chat room created successfully"));
    }

    @PutMapping("/rooms/{roomId}")
    @Operation(summary = "Update chat room", description = "Update room name and/or description")
    public ResponseEntity<ApiResponse<ChatRoomResponse>> updateRoom(
            @PathVariable UUID roomId,
            @Valid @RequestBody UpdateRoomRequest request) {
        ChatRoomResponse response = chatRoomService.updateRoom(roomId, request);
        return ResponseEntity.ok(ApiResponse.success(response, "Chat room updated successfully"));
    }

    @DeleteMapping("/rooms/{roomId}")
    @Operation(summary = "Delete chat room", description = "Soft-delete (deactivate) a chat room")
    public ResponseEntity<ApiResponse<Void>> deleteRoom(@PathVariable UUID roomId) {
        chatRoomService.deleteRoom(roomId);
        return ResponseEntity.ok(ApiResponse.success("Chat room deleted successfully"));
    }

    @GetMapping("/rooms/{roomId}/statistics")
    @Operation(summary = "Get room statistics", description = "Get member count, message count, and active participants")
    public ResponseEntity<ApiResponse<RoomStatisticsResponse>> getRoomStatistics(@PathVariable UUID roomId) {
        RoomStatisticsResponse response = chatRoomService.getRoomStatistics(roomId);
        return ResponseEntity.ok(ApiResponse.success(response, "Room statistics retrieved successfully"));
    }

    // ===================== MUTE =====================

    @PostMapping("/rooms/{roomId}/mute/{userId}")
    @Operation(summary = "Mute user", description = "Mute a user in a specific chat room")
    public ResponseEntity<ApiResponse<Void>> muteUser(
            @AuthenticationPrincipal UserPrincipal principal,
            @PathVariable UUID roomId,
            @PathVariable UUID userId,
            @Valid @RequestBody MuteUserRequest request) {
        chatRoomService.muteUser(roomId, userId, principal.getId(), request);
        return ResponseEntity.ok(ApiResponse.success("User muted successfully"));
    }

    @DeleteMapping("/rooms/{roomId}/mute/{userId}")
    @Operation(summary = "Unmute user", description = "Unmute a user in a specific chat room")
    public ResponseEntity<ApiResponse<Void>> unmuteUser(
            @PathVariable UUID roomId,
            @PathVariable UUID userId) {
        chatRoomService.unmuteUser(roomId, userId);
        return ResponseEntity.ok(ApiResponse.success("User unmuted successfully"));
    }

    // ===================== MESSAGES =====================

    @DeleteMapping("/messages/{messageId}")
    @Operation(summary = "Delete any message", description = "Admin can hard-delete any message in the system")
    public ResponseEntity<ApiResponse<Void>> deleteMessage(@PathVariable UUID messageId) {
        chatMessageService.adminDeleteMessage(messageId);
        return ResponseEntity.ok(ApiResponse.success("Message deleted successfully"));
    }
}
