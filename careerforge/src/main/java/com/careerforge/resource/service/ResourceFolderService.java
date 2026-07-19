package com.careerforge.resource.service;

import com.careerforge.resource.dto.CreateFolderRequest;
import com.careerforge.resource.dto.FolderDto;
import com.careerforge.resource.dto.FolderDirectoryDto;
import com.careerforge.resource.dto.UpdateFolderRequest;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ResourceFolderService {
    FolderDto createFolder(CreateFolderRequest request);
    FolderDto updateFolder(UUID id, UpdateFolderRequest request);
    void deleteFolder(UUID id);
    FolderDirectoryDto getFolderDirectory(UUID folderId, Pageable pageable);
}
