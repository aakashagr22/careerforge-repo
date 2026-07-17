package com.careerforge.roadmap.service;

import com.careerforge.roadmap.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface RoadmapService {
    // Roadmap CRUD
    RoadmapDto createRoadmap(CreateRoadmapRequest request);
    RoadmapDto updateRoadmap(UUID id, UpdateRoadmapRequest request);
    void deleteRoadmap(UUID id);
    RoadmapDto getRoadmapById(UUID id);
    Page<RoadmapDto> getAllRoadmaps(Pageable pageable);

    // RoadmapPhase CRUD
    RoadmapPhaseDto createRoadmapPhase(CreateRoadmapPhaseRequest request);
    RoadmapPhaseDto updateRoadmapPhase(UUID id, UpdateRoadmapPhaseRequest request);
    void deleteRoadmapPhase(UUID id);
    RoadmapPhaseDto getRoadmapPhaseById(UUID id);
    List<RoadmapPhaseDto> getPhasesByRoadmapId(UUID roadmapId);

    // Student Personalized Generation
    PersonalizedRoadmapResponse getPersonalizedRoadmap(UUID studentUserId);
}
