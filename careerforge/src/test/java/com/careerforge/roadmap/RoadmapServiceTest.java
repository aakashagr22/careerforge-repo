package com.careerforge.roadmap;

import com.careerforge.exception.BadRequestException;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.roadmap.dto.*;
import com.careerforge.roadmap.entity.Roadmap;
import com.careerforge.roadmap.entity.RoadmapSection;
import com.careerforge.roadmap.mapper.QuestionMapper;
import com.careerforge.roadmap.mapper.RoadmapMapper;
import com.careerforge.roadmap.mapper.RoadmapSectionMapper;
import com.careerforge.roadmap.repository.*;
import com.careerforge.roadmap.service.impl.RoadmapServiceImpl;
import com.careerforge.student.entity.Language;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.entity.TargetRole;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoadmapServiceTest {

    @Mock
    private RoadmapRepository roadmapRepository;

    @Mock
    private RoadmapSectionRepository roadmapSectionRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private QuestionLinkRepository questionLinkRepository;

    @Mock
    private RoadmapSectionQuestionRepository roadmapSectionQuestionRepository;

    @Mock
    private StudentRoadmapQuestionProgressRepository studentRoadmapQuestionProgressRepository;

    @Mock
    private StudentProfileRepository studentProfileRepository;

    @Mock
    private RoadmapMapper roadmapMapper;

    @Mock
    private RoadmapSectionMapper roadmapSectionMapper;

    @Mock
    private QuestionMapper questionMapper;

    @InjectMocks
    private RoadmapServiceImpl roadmapService;

    private Roadmap roadmap;
    private RoadmapDto roadmapDto;
    private CreateRoadmapRequest createRequest;
    private StudentProfile student;
    private RoadmapSection section;
    private RoadmapSectionTreeDto sectionTreeDto;

    @BeforeEach
    void setUp() {
        UUID roadmapId = UUID.randomUUID();
        UUID sectionId = UUID.randomUUID();
        UUID studentId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        roadmap = Roadmap.builder()
                .id(roadmapId)
                .semester(5)
                .monthsRemaining(12)
                .targetRoles(List.of(TargetRole.SDE))
                .title("SDE Roadmap")
                .description("Path to SDE")
                .build();

        roadmapDto = RoadmapDto.builder()
                .id(roadmapId)
                .semester(5)
                .monthsRemaining(12)
                .targetRoles(List.of(TargetRole.SDE))
                .title("SDE Roadmap")
                .description("Path to SDE")
                .build();

        createRequest = CreateRoadmapRequest.builder()
                .semester(5)
                .monthsRemaining(12)
                .targetRoles(List.of(TargetRole.SDE))
                .title("SDE Roadmap")
                .description("Path to SDE")
                .build();

        student = StudentProfile.builder()
                .id(studentId)
                .user(User.builder().id(userId).build())
                .semester(5)
                .preferredLanguage(Language.JAVA)
                .targetRole(TargetRole.SDE)
                .build();

        section = RoadmapSection.builder()
                .id(sectionId)
                .roadmap(roadmap)
                .title("Basics")
                .position(0)
                .build();

        sectionTreeDto = RoadmapSectionTreeDto.builder()
                .id(sectionId)
                .title("Basics")
                .position(0)
                .children(new ArrayList<>())
                .questions(new ArrayList<>())
                .build();
    }

    @Test
    void createRoadmap_ShouldSaveAndReturnDto() {
        when(roadmapRepository.save(any(Roadmap.class))).thenReturn(roadmap);
        when(roadmapMapper.toDto(roadmap)).thenReturn(roadmapDto);

        RoadmapDto result = roadmapService.createRoadmap(createRequest);

        assertNotNull(result);
        assertEquals("SDE Roadmap", result.getTitle());
        verify(roadmapRepository, times(1)).save(any(Roadmap.class));
    }

    @Test
    void getRoadmapById_ShouldReturnDto_WhenExists() {
        when(roadmapRepository.findById(roadmap.getId())).thenReturn(Optional.of(roadmap));
        when(roadmapMapper.toDto(roadmap)).thenReturn(roadmapDto);

        RoadmapDto result = roadmapService.getRoadmapById(roadmap.getId());

        assertNotNull(result);
        assertEquals(roadmap.getId(), result.getId());
    }

    @Test
    void createSection_ShouldSaveAndReturnDto_WhenRoadmapExists() {
        when(roadmapRepository.findById(roadmap.getId())).thenReturn(Optional.of(roadmap));
        when(roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmap.getId())).thenReturn(Collections.emptyList());
        when(roadmapSectionRepository.save(any(RoadmapSection.class))).thenReturn(section);
        when(roadmapSectionMapper.toTreeDto(section)).thenReturn(sectionTreeDto);

        CreateRoadmapSectionRequest request = CreateRoadmapSectionRequest.builder()
                .roadmapId(roadmap.getId())
                .title("Basics")
                .position(0)
                .build();

        RoadmapSectionTreeDto result = roadmapService.createSection(request);

        assertNotNull(result);
        assertEquals("Basics", result.getTitle());
    }

    @Test
    void getPersonalizedRoadmap_ShouldReturnRoadmapWithSections() {
        when(studentProfileRepository.findByUserId(student.getUser().getId())).thenReturn(Optional.of(student));
        when(roadmapRepository.findBySemesterAndTargetRole(5, "SDE")).thenReturn(Optional.of(roadmap));
        when(roadmapSectionRepository.findByRoadmapIdOrderByPositionAsc(roadmap.getId())).thenReturn(List.of(section));
        when(roadmapSectionQuestionRepository.findByRoadmapSectionRoadmapId(roadmap.getId())).thenReturn(Collections.emptyList());
        when(roadmapMapper.toDto(roadmap)).thenReturn(roadmapDto);
        when(roadmapSectionMapper.toTreeDto(section)).thenReturn(sectionTreeDto);

        PersonalizedRoadmapResponse result = roadmapService.getPersonalizedRoadmap(student.getUser().getId());

        assertNotNull(result);
        assertEquals("SDE Roadmap", result.getRoadmap().getTitle());
        assertEquals(1, result.getSections().size());
        assertEquals("Basics", result.getSections().get(0).getTitle());
    }

    @Test
    void updateSection_ShouldThrowException_WhenCycleDetected() {
        UUID sectionId = section.getId();
        RoadmapSection parentSec = RoadmapSection.builder()
                .id(UUID.randomUUID())
                .roadmap(roadmap)
                .title("Sub Section")
                .parentSection(section)
                .position(0)
                .build();

        when(roadmapSectionRepository.findById(sectionId)).thenReturn(Optional.of(section));
        when(roadmapSectionRepository.findById(parentSec.getId())).thenReturn(Optional.of(parentSec));

        UpdateRoadmapSectionRequest request = UpdateRoadmapSectionRequest.builder()
                .parentId(parentSec.getId())
                .title("Basics (Updated)")
                .position(0)
                .build();

        assertThrows(BadRequestException.class, () -> roadmapService.updateSection(sectionId, request));
    }
}
