package com.careerforge.chat.websocket;

import com.careerforge.chat.dto.request.SendMessageRequest;
import com.careerforge.chat.dto.response.ChatMessageResponse;
import com.careerforge.chat.service.ChatMessageService;
import com.careerforge.security.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.UUID;

/**
 * STOMP message controller for real-time chat.
 * <p>
 * Clients send messages to:
 *   - /app/chat.room.{roomId} → broadcasts to /topic/chat/{roomId}
 *   - /app/chat.private.{conversationId} → sends to /topic/private/{conversationId}
 */
@Slf4j
@Controller
public class ChatWebSocketController {

    private final ChatMessageService chatMessageService;
    private final SimpMessagingTemplate messagingTemplate;

    public ChatWebSocketController(ChatMessageService chatMessageService,
                                    SimpMessagingTemplate messagingTemplate) {
        this.chatMessageService = chatMessageService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat.room.{roomId}")
    public void sendRoomMessage(@DestinationVariable UUID roomId,
                                @Payload SendMessageRequest request,
                                Principal principal) {
        UUID senderId = extractUserId(principal);
        request.setChatRoomId(roomId);
        request.setConversationId(null);

        ChatMessageResponse response = chatMessageService.sendMessage(senderId, request);

        messagingTemplate.convertAndSend("/topic/chat/" + roomId, response);
        log.debug("Broadcast message to /topic/chat/{}", roomId);
    }

    @MessageMapping("/chat.private.{conversationId}")
    public void sendPrivateMessage(@DestinationVariable UUID conversationId,
                                   @Payload SendMessageRequest request,
                                   Principal principal) {
        UUID senderId = extractUserId(principal);
        request.setConversationId(conversationId);
        request.setChatRoomId(null);

        ChatMessageResponse response = chatMessageService.sendMessage(senderId, request);

        messagingTemplate.convertAndSend("/topic/private/" + conversationId, response);
        log.debug("Broadcast private message to /topic/private/{}", conversationId);
    }

    private UUID extractUserId(Principal principal) {
        if (principal instanceof UsernamePasswordAuthenticationToken authToken) {
            Object principalObj = authToken.getPrincipal();
            if (principalObj instanceof UserPrincipal userPrincipal) {
                return userPrincipal.getId();
            }
        }
        throw new IllegalStateException("Unable to extract user ID from principal");
    }
}
