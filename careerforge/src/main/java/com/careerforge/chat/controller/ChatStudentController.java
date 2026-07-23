package com.careerforge.chat.controller;

import com.careerforge.chat.dto.request.CreateConversationRequest;
import com.careerforge.chat.dto.request.EditMessageRequest;
import com.careerforge.chat.dto.request.SendMessageRequest;
import com.careerforge.chat.dto.response.*;
import com.careerforge.chat.service.ChatMessageService;
import com.careerforge.chat.service.ChatRoomService;
import com.careerforge.chat.service.PrivateConversationService;
import com.careerforge.common.dto.ApiResponse;
import com.careerforge.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/student/chat")
@Tag(name = "Student Chat", description = "Chat APIs for students")
public class ChatStudentController {

    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;
    private final PrivateConversationService privateConversationService;

    public ChatStudentController(ChatRoomService chatRoomService,
                                  ChatMessageService chatMessageService,
                                  PrivateConversationService privateConversationService) {
        this.chatRoomService = chatRoomService;
        this.chatMessageService = chatMessageService;
        this.privateConversationService = privateConversationService;
    }

    // ===================== ROOMS =====================

    @GetMapping("/rooms")
    @Operation(summary = "Get accessible chat rooms", description = "Returns rooms accessible based on student's semester")
    public ResponseEntity<ApiResponse<List<ChatRoomResponse>>> getAccessibleRooms(
            @AuthenticationPrincipal UserPrincipal principal) {
        List<ChatRoomResponse> rooms = chatRoomService.getAccessibleRooms(principal.getId());
        return ResponseEntity.ok(ApiResponse.success(rooms, "Accessible rooms retrieved successfully"));
    }

    @GetMapping("/rooms/{roomId}/messages")
    @Operation(summary = "Get room messages", description = "Returns paginated messages for a chat room")
    public ResponseEntity<ApiResponse<Page<ChatMessageResponse>>> getRoomMessages(
            @AuthenticationPrincipal UserPrincipal principal,
            @PathVariable UUID roomId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ChatMessageResponse> messages = chatMessageService.getRoomMessages(principal.getId(), roomId, pageable);
        return ResponseEntity.ok(ApiResponse.success(messages, "Room messages retrieved successfully"));
    }

    // ===================== CONVERSATIONS =====================

    @PostMapping("/conversations")
    @Operation(summary = "Create private conversation", description = "Start a private conversation with another user")
    public ResponseEntity<ApiResponse<PrivateConversationResponse>> createConversation(
            @AuthenticationPrincipal UserPrincipal principal,
            @Valid @RequestBody CreateConversationRequest request) {
        PrivateConversationResponse response = privateConversationService.createConversation(principal.getId(), request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Conversation created successfully"));
    }

    @GetMapping("/conversations")
    @Operation(summary = "Get private conversations", description = "Returns all private conversations for the current user")
    public ResponseEntity<ApiResponse<List<PrivateConversationResponse>>> getConversations(
            @AuthenticationPrincipal UserPrincipal principal) {
        List<PrivateConversationResponse> conversations = privateConversationService.getConversations(principal.getId());
        return ResponseEntity.ok(ApiResponse.success(conversations, "Conversations retrieved successfully"));
    }

    @GetMapping("/conversations/{conversationId}/messages")
    @Operation(summary = "Get conversation messages", description = "Returns paginated messages for a private conversation")
    public ResponseEntity<ApiResponse<Page<ChatMessageResponse>>> getConversationMessages(
            @AuthenticationPrincipal UserPrincipal principal,
            @PathVariable UUID conversationId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ChatMessageResponse> messages = chatMessageService.getConversationMessages(
                principal.getId(), conversationId, pageable);
        return ResponseEntity.ok(ApiResponse.success(messages, "Conversation messages retrieved successfully"));
    }

    // ===================== MESSAGES =====================

    @PostMapping("/messages")
    @Operation(summary = "Send message", description = "Send a message to a room or private conversation (REST fallback)")
    public ResponseEntity<ApiResponse<ChatMessageResponse>> sendMessage(
            @AuthenticationPrincipal UserPrincipal principal,
            @Valid @RequestBody SendMessageRequest request) {
        ChatMessageResponse response = chatMessageService.sendMessage(principal.getId(), request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Message sent successfully"));
    }

    @PutMapping("/messages/{messageId}")
    @Operation(summary = "Edit message", description = "Edit your own message")
    public ResponseEntity<ApiResponse<ChatMessageResponse>> editMessage(
            @AuthenticationPrincipal UserPrincipal principal,
            @PathVariable UUID messageId,
            @Valid @RequestBody EditMessageRequest request) {
        ChatMessageResponse response = chatMessageService.editMessage(principal.getId(), messageId, request);
        return ResponseEntity.ok(ApiResponse.success(response, "Message edited successfully"));
    }

    @DeleteMapping("/messages/{messageId}")
    @Operation(summary = "Delete message", description = "Soft-delete your own message")
    public ResponseEntity<ApiResponse<Void>> deleteMessage(
            @AuthenticationPrincipal UserPrincipal principal,
            @PathVariable UUID messageId) {
        chatMessageService.deleteMessage(principal.getId(), messageId);
        return ResponseEntity.ok(ApiResponse.success("Message deleted successfully"));
    }

    // ===================== USER SEARCH =====================

    @GetMapping("/users/search")
    @Operation(summary = "Search users", description = "Search users by name or email for starting a private conversation")
    public ResponseEntity<ApiResponse<List<UserSearchResponse>>> searchUsers(
            @AuthenticationPrincipal UserPrincipal principal,
            @RequestParam String query) {
        List<UserSearchResponse> users = privateConversationService.searchUsers(principal.getId(), query);
        return ResponseEntity.ok(ApiResponse.success(users, "Users found successfully"));
    }
}
