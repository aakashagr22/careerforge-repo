package com.careerforge.chat.websocket;

import com.careerforge.security.CustomUserDetailsService;
import com.careerforge.security.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Intercepts STOMP CONNECT frames to authenticate using the existing JWT infrastructure.
 * <p>
 * The client sends the JWT token in the STOMP "Authorization" header:
 * <pre>
 * stompClient.connect({
 *   Authorization: "Bearer eyJhb..."
 * }, callback);
 * </pre>
 */
@Slf4j
@Component
public class WebSocketAuthInterceptor implements ChannelInterceptor {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService customUserDetailsService;

    public WebSocketAuthInterceptor(JwtTokenProvider jwtTokenProvider,
                                     CustomUserDetailsService customUserDetailsService) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (accessor != null && StompCommand.CONNECT.equals(accessor.getCommand())) {
            String authHeader = accessor.getFirstNativeHeader("Authorization");

            if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);

                if (jwtTokenProvider.validateToken(token)) {
                    String email = jwtTokenProvider.getEmailFromJWT(token);
                    UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);

                    if (userDetails.isEnabled()) {
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(
                                        userDetails, null, userDetails.getAuthorities());

                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        accessor.setUser(authentication);
                        log.debug("WebSocket authenticated for user: {}", email);
                    } else {
                        log.warn("WebSocket connection rejected: user account is disabled for {}", email);
                    }
                } else {
                    log.warn("WebSocket connection rejected: invalid JWT token");
                }
            } else {
                log.warn("WebSocket connection rejected: no Authorization header provided");
            }
        }

        return message;
    }
}
