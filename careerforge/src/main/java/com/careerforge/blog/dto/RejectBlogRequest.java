package com.careerforge.blog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RejectBlogRequest {

    @NotBlank(message = "Rejection reason is required")
    private String rejectionReason;
}
