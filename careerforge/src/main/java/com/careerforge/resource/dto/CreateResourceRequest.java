package com.careerforge.resource.dto;

import com.careerforge.resource.entity.ResourceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateResourceRequest {

    @NotBlank(message = "Title is required")
    @Size(max = 150, message = "Title must not exceed 150 characters")
    private String title;

    private String description;

    @NotNull(message = "Type is required")
    private ResourceType type;

    @NotBlank(message = "URL is required")
    @URL(message = "URL must be a valid URL")
    private String url;

    @URL(message = "Thumbnail must be a valid URL")
    private String thumbnail;

    private UUID folderId;
}
