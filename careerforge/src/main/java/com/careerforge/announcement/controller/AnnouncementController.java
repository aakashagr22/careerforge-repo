package com.careerforge.announcement.controller;

import com.careerforge.announcement.dto.AnnouncementDto;
import com.careerforge.announcement.dto.CreateAnnouncementRequest;
import com.careerforge.announcement.service.AnnouncementService;
import com.careerforge.common.dto.ApiResponse;
import com.careerforge.security.UserPrincipal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "Announcements", description = "APIs for platform announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    // ======================== Shared (Student + Admin) Endpoints ========================

    @GetMapping("/api/announcements")
    @Operation(summary = "Get all announcements (Student + Admin)")
    public ResponseEntity<ApiResponse<Page<AnnouncementDto>>> getAnnouncements(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AnnouncementDto> announcements = announcementService.getAnnouncements(pageable);
        return ResponseEntity.ok(ApiResponse.success(announcements, "Announcements retrieved successfully"));
    }

    // ======================== Admin-Only Endpoints ========================

    @PostMapping("/api/admin/announcements")
    @Operation(summary = "Create a new announcement (Admin)")
    public ResponseEntity<ApiResponse<AnnouncementDto>> createAnnouncement(
            @Valid @RequestBody CreateAnnouncementRequest request,
            @AuthenticationPrincipal UserPrincipal principal) {
        AnnouncementDto dto = announcementService.createAnnouncement(request, principal.getId());
        return new ResponseEntity<>(ApiResponse.success(dto, "Announcement created successfully"), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/announcements/{id}")
    @Operation(summary = "Delete an announcement (Admin)")
    public ResponseEntity<ApiResponse<Void>> deleteAnnouncement(@PathVariable UUID id) {
        announcementService.deleteAnnouncement(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Announcement deleted successfully"));
    }
}
