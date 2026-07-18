package com.careerforge.roadmap;

import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.roadmap.dto.*;
import com.careerforge.roadmap.entity.Roadmap;
import com.careerforge.roadmap.entity.RoadmapPhase;
import com.careerforge.roadmap.mapper.RoadmapMapper;
import com.careerforge.roadmap.mapper.RoadmapPhaseMapper;
import com.careerforge.roadmap.repository.RoadmapPhaseRepository;
import com.careerforge.roadmap.repository.RoadmapRepository;
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
    private RoadmapPhaseRepository roadmapPhaseRepository;

    @Mock
    private StudentProfileRepository studentProfileRepository;

    @Mock
    private RoadmapMapper roadmapMapper;

    @Mock
    private RoadmapPhaseMapper roadmapPhaseMapper;

    @InjectMocks
    private RoadmapServiceImpl roadmapService;

    private Roadmap roadmap;
    private RoadmapDto roadmapDto;
    private CreateRoadmapRequest createRequest;
    private UpdateRoadmapRequest updateRequest;

    private RoadmapPhase phase;
    private RoadmapPhaseDto phaseDto;
    private CreateRoadmapPhaseRequest createPhaseRequest;
    private UpdateRoadmapPhaseRequest updatePhaseRequest;

    private StudentProfile student;

    @BeforeEach
    void setUp() {
        UUID roadmapId = UUID.randomUUID();
        UUID phaseId = UUID.randomUUID();
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

        updateRequest = UpdateRoadmapRequest.builder()
                .semester(5)
                .monthsRemaining(10)
                .targetRoles(List.of(TargetRole.SDE))
                .title("SDE Roadmap (Updated)")
                .build();

        phase = RoadmapPhase.builder()
                .id(phaseId)
                .roadmap(roadmap)
                .title("DSA Foundation")
                .description("Algorithms core")
                .startMonth(1)
                .endMonth(4)
                .priority(1)
                .build();

        phaseDto = RoadmapPhaseDto.builder()
                .id(phaseId)
                .roadmapId(roadmapId)
                .title("DSA Foundation")
                .description("Algorithms core")
                .startMonth(1)
                .endMonth(4)
                .priority(1)
                .build();

        createPhaseRequest = CreateRoadmapPhaseRequest.builder()
                .roadmapId(roadmapId)
                .title("DSA Foundation")
                .startMonth(1)
                .endMonth(4)
                .priority(1)
                .build();

        updatePhaseRequest = UpdateRoadmapPhaseRequest.builder()
                .title("DSA Advanced")
                .startMonth(1)
                .endMonth(4)
                .priority(1)
                .build();

        student = StudentProfile.builder()
                .id(studentId)
                .user(User.builder().id(userId).build())
                .semester(5)
                .preferredLanguage(Language.JAVA)
                .targetRole(TargetRole.SDE)
                .communicationTrackEnabled(false)
                .build();
    }

    // ======================== Roadmap Tests ========================

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

    // ======================== Phase Tests ========================

    @Test
    void createRoadmapPhase_ShouldSaveAndReturnDto_WhenRoadmapExists() {
        when(roadmapRepository.findById(roadmap.getId())).thenReturn(Optional.of(roadmap));
        when(roadmapPhaseRepository.save(any(RoadmapPhase.class))).thenReturn(phase);
        when(roadmapPhaseMapper.toDto(phase)).thenReturn(phaseDto);

        RoadmapPhaseDto result = roadmapService.createRoadmapPhase(createPhaseRequest);

        assertNotNull(result);
        assertEquals("DSA Foundation", result.getTitle());
    }

    // ======================== Personalized Roadmap Retrieval ========================

    @Test
    void getPersonalizedRoadmap_ShouldReturnRoadmapWithPhases() {
        when(studentProfileRepository.findByUserId(student.getUser().getId())).thenReturn(Optional.of(student));
        when(roadmapRepository.findBySemesterAndTargetRole(5, "SDE")).thenReturn(Optional.of(roadmap));
        when(roadmapPhaseRepository.findByRoadmapIdOrderByPriorityAsc(roadmap.getId())).thenReturn(List.of(phase));
        when(roadmapMapper.toDto(roadmap)).thenReturn(roadmapDto);
        when(roadmapPhaseMapper.toDto(phase)).thenReturn(phaseDto);

        PersonalizedRoadmapResponse result = roadmapService.getPersonalizedRoadmap(student.getUser().getId());

        assertNotNull(result);
        assertEquals("SDE Roadmap", result.getRoadmap().getTitle());
        assertEquals(1, result.getPhases().size());
        assertEquals("DSA Foundation", result.getPhases().get(0).getTitle());
    }

    @Test
    void getPersonalizedRoadmap_ShouldAppendSoftSkillsPhase_WhenCommunicationTrackEnabled() {
        student.setCommunicationTrackEnabled(true);
        when(studentProfileRepository.findByUserId(student.getUser().getId())).thenReturn(Optional.of(student));
        when(roadmapRepository.findBySemesterAndTargetRole(5, "SDE")).thenReturn(Optional.of(roadmap));
        when(roadmapPhaseRepository.findByRoadmapIdOrderByPriorityAsc(roadmap.getId())).thenReturn(List.of(phase));
        when(roadmapMapper.toDto(roadmap)).thenReturn(roadmapDto);
        when(roadmapPhaseMapper.toDto(phase)).thenReturn(phaseDto);

        PersonalizedRoadmapResponse result = roadmapService.getPersonalizedRoadmap(student.getUser().getId());

        assertNotNull(result);
        assertEquals(2, result.getPhases().size());
        assertEquals("Communication & Interview Skills", result.getPhases().get(1).getTitle());
        assertEquals(100, result.getPhases().get(1).getPriority());
    }

    @Test
    void getPersonalizedRoadmap_ShouldThrowException_WhenNoMatchingRoadmap() {
        when(studentProfileRepository.findByUserId(student.getUser().getId())).thenReturn(Optional.of(student));
        when(roadmapRepository.findBySemesterAndTargetRole(5, "SDE")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> roadmapService.getPersonalizedRoadmap(student.getUser().getId()));
    }
}
