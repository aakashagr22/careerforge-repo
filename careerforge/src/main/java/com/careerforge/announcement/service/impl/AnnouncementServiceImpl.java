package com.careerforge.announcement.service.impl;

import com.careerforge.announcement.dto.AnnouncementDto;
import com.careerforge.announcement.dto.CreateAnnouncementRequest;
import com.careerforge.announcement.entity.Announcement;
import com.careerforge.announcement.repository.AnnouncementRepository;
import com.careerforge.announcement.service.AnnouncementService;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.user.entity.User;
import com.careerforge.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final UserRepository userRepository;

    // In-memory cache for announcements pages (cleared on admin create/delete)
    private final Map<String, Page<AnnouncementDto>> announcementsCache = new ConcurrentHashMap<>();

    @Override
    @Transactional
    public AnnouncementDto createAnnouncement(CreateAnnouncementRequest request, UUID adminId) {
        User admin = userRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin user not found"));

        Announcement announcement = Announcement.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .priority(request.getPriority() != null ? request.getPriority() : com.careerforge.announcement.entity.AnnouncementPriority.NORMAL)
                .createdBy(admin)
                .build();

        Announcement saved = announcementRepository.save(announcement);
        // Invalidate in-memory cache upon new announcement creation
        announcementsCache.clear();
        log.info("Announcement created with ID: {} by admin: {} and cache invalidated", saved.getId(), adminId);
        return toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AnnouncementDto> getAnnouncements(Pageable pageable) {
        String cacheKey = pageable.getPageNumber() + ":" + pageable.getPageSize();
        Page<AnnouncementDto> cached = announcementsCache.get(cacheKey);
        if (cached != null) {
            log.debug("Serving announcements from in-memory cache for key: {}", cacheKey);
            return cached;
        }

        Page<AnnouncementDto> fresh = announcementRepository.findAllByOrderByCreatedAtDesc(pageable)
                .map(this::toDto);
        announcementsCache.put(cacheKey, fresh);
        return fresh;
    }

    @Override
    @Transactional
    public void deleteAnnouncement(UUID id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found"));
        announcementRepository.delete(announcement);
        // Invalidate in-memory cache upon announcement deletion
        announcementsCache.clear();
        log.info("Announcement deleted with ID: {} and cache invalidated", id);
    }

    private AnnouncementDto toDto(Announcement a) {
        String createdByName = null;
        UUID createdById = null;
        if (a.getCreatedBy() != null) {
            createdById = a.getCreatedBy().getId();
            createdByName = a.getCreatedBy().getFirstName() + " " + a.getCreatedBy().getLastName();
        }
        return AnnouncementDto.builder()
                .id(a.getId())
                .title(a.getTitle())
                .content(a.getContent())
                .priority(a.getPriority())
                .createdById(createdById)
                .createdByName(createdByName)
                .createdAt(a.getCreatedAt())
                .updatedAt(a.getUpdatedAt())
                .build();
    }
}
