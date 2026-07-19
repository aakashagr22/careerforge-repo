package com.careerforge.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FolderDirectoryDto {
    private FolderDto currentFolder;
    private List<FolderBreadcrumbDto> breadcrumbs;
    private List<FolderDto> childFolders;
    private Page<ResourceDto> resources;
}
