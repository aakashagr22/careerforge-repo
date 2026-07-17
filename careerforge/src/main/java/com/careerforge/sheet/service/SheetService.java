package com.careerforge.sheet.service;

import com.careerforge.sheet.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SheetService {
    // Sheet CRUD
    SheetDto createSheet(CreateSheetRequest request);
    SheetDto updateSheet(UUID id, UpdateSheetRequest request);
    void deleteSheet(UUID id);
    SheetDto getSheetById(UUID id);
    Page<SheetDto> getAllSheets(Pageable pageable);

    // SheetTopic CRUD
    SheetTopicDto createSheetTopic(CreateSheetTopicRequest request);
    SheetTopicDto updateSheetTopic(UUID id, UpdateSheetTopicRequest request);
    void deleteSheetTopic(UUID id);
    SheetTopicDto getSheetTopicById(UUID id);
    List<SheetTopicDto> getTopicsBySheetId(UUID sheetId);

    // Student Progress
    StudentSheetProgressDto markTopicCompleted(UUID studentUserId, UUID topicId, boolean completed);
    double getProgressPercentage(UUID studentUserId, UUID sheetId);
    List<UUID> getCompletedTopicIds(UUID studentUserId);
}
