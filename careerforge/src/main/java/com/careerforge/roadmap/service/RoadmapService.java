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

    // RoadmapSection CRUD
    RoadmapSectionTreeDto createSection(CreateRoadmapSectionRequest request);
    RoadmapSectionTreeDto updateSection(UUID id, UpdateRoadmapSectionRequest request);
    void deleteSection(UUID id);
    List<RoadmapSectionTreeDto> getSectionsTreeByRoadmapId(UUID roadmapId);

    // Question CRUD
    QuestionDto createQuestion(CreateQuestionRequest request);
    QuestionDto updateQuestion(UUID id, UpdateQuestionRequest request);
    void deleteQuestion(UUID id);
    List<QuestionDto> getAllQuestions();

    // QuestionLink CRUD
    QuestionLinkDto createQuestionLink(UUID questionId, CreateQuestionLinkRequest request);
    QuestionLinkDto updateQuestionLink(UUID linkId, UpdateQuestionLinkRequest request);
    void deleteQuestionLink(UUID linkId);

    // Section Question assignment
    RoadmapSectionQuestionDto assignQuestionToSection(UUID sectionId, AssignQuestionRequest request);
    void removeQuestionFromSection(UUID sectionQuestionId);

    // Student Personalized Generation
    PersonalizedRoadmapResponse getPersonalizedRoadmap(UUID studentUserId, UUID roadmapId);
    
    // Student Progress Tracking
    void updateStudentQuestionProgress(UUID studentUserId, UUID sectionQuestionId, UpdateStudentProgressRequest request);

    // Seeder
    void seedDsaRoadmap(UUID roadmapId);
    void seedSpringBootRoadmap(UUID roadmapId);
    void seedMernRoadmap(UUID roadmapId);
    void seedFastApiRoadmap(UUID roadmapId);
    void seedFrontendRoadmap(UUID roadmapId);
    void seedAiMlRoadmap(UUID roadmapId);
    void seedDataScientistRoadmap(UUID roadmapId);
    void seedPythonRoadmap(UUID roadmapId);
    void seedCppRoadmap(UUID roadmapId);
    void seedJavaRoadmap(UUID roadmapId);
    void seedCpSheetRoadmap(UUID roadmapId);
}



