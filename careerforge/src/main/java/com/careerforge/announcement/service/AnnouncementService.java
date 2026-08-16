package com.careerforge.announcement.service;

import com.careerforge.announcement.dto.AnnouncementDto;
import com.careerforge.announcement.dto.CreateAnnouncementRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AnnouncementService {

    AnnouncementDto createAnnouncement(CreateAnnouncementRequest request, UUID adminId);

    Page<AnnouncementDto> getAnnouncements(Pageable pageable);

    void deleteAnnouncement(UUID id);
}
