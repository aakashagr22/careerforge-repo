package com.careerforge.chat.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MuteUserRequest {

    @Size(max = 500, message = "Reason must not exceed 500 characters")
    private String reason;

    /**
     * Optional expiry. If null, mute is permanent until manually unmuted.
     */
    private LocalDateTime expiresAt;
}
