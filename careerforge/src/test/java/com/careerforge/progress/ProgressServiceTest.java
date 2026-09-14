package com.careerforge.progress;

import com.careerforge.progress.dto.DashboardResponseDto;
import com.careerforge.progress.entity.Progress;
import com.careerforge.progress.repository.ProgressRepository;
import com.careerforge.progress.service.impl.ProgressServiceImpl;
import com.careerforge.sheet.entity.Sheet;
import com.careerforge.sheet.repository.SheetRepository;
import com.careerforge.sheet.repository.SheetTopicRepository;
import com.careerforge.sheet.repository.StudentSheetProgressRepository;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.entity.TargetRole;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.roadmap.repository.RoadmapRepository;
import com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository;
import com.careerforge.roadmap.repository.StudentRoadmapQuestionProgressRepository;
import com.careerforge.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProgressServiceTest {

    @Mock
    private ProgressRepository progressRepository;

    @Mock
    private StudentProfileRepository studentProfileRepository;

    @Mock
    private SheetRepository sheetRepository;

    @Mock
    private SheetTopicRepository sheetTopicRepository;

    @Mock
    private StudentSheetProgressRepository studentSheetProgressRepository;

    @Mock
    private RoadmapRepository roadmapRepository;

    @Mock
    private RoadmapSectionQuestionRepository roadmapSectionQuestionRepository;

    @Mock
    private StudentRoadmapQuestionProgressRepository studentRoadmapQuestionProgressRepository;

    @InjectMocks
    private ProgressServiceImpl progressService;

    private UUID userId;
    private StudentProfile student;
    private Progress progress;
    private Sheet sheet;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
        UUID studentId = UUID.randomUUID();

        student = StudentProfile.builder()
                .id(studentId)
                .user(User.builder().id(userId).build())
                .streak(0)
                .semester(5)
                .targetRole(TargetRole.SDE)
                .build();

        progress = Progress.builder()
                .id(UUID.randomUUID())
                .student(student)
                .completedSheets(0)
                .completedTopics(0)
                .currentStreak(3)
                .lastActive(LocalDateTime.now().minusDays(1)) // yesterday
                .build();

        sheet = Sheet.builder()
                .id(UUID.randomUUID())
                .title("Basic Array Sheet")
                .build();
    }

    @Test
    void getStudentDashboard_ShouldReturnFullMetrics() {
        when(studentProfileRepository.findByUserId(userId)).thenReturn(Optional.of(student));
        when(progressRepository.findByStudentId(student.getId())).thenReturn(Optional.of(progress));
        when(studentSheetProgressRepository.countByStudentIdAndCompletedTrue(student.getId())).thenReturn(5L);
        when(sheetRepository.findAll()).thenReturn(List.of(sheet));
        when(sheetTopicRepository.countBySheetId(sheet.getId())).thenReturn(5L);
        when(studentSheetProgressRepository.countCompletedByStudentIdAndSheetId(student.getId(), sheet.getId())).thenReturn(5L);
        when(studentSheetProgressRepository.findAllByStudentId(student.getId())).thenReturn(Collections.emptyList());
        when(progressRepository.save(any(Progress.class))).thenReturn(progress);

        com.careerforge.roadmap.entity.Roadmap mockRoadmap = com.careerforge.roadmap.entity.Roadmap.builder()
                .id(UUID.randomUUID())
                .build();
        when(roadmapRepository.findBySemesterAndTargetRole(5, "SDE")).thenReturn(Optional.of(mockRoadmap));
        
        List<com.careerforge.roadmap.entity.RoadmapSectionQuestion> mockList = java.util.Collections.nCopies(10, new com.careerforge.roadmap.entity.RoadmapSectionQuestion());
        when(roadmapSectionQuestionRepository.findByRoadmapSectionRoadmapId(mockRoadmap.getId())).thenReturn(mockList);
        when(studentRoadmapQuestionProgressRepository.countByStudentIdAndRoadmapSectionQuestionRoadmapSectionRoadmapIdAndCompletedTrue(student.getId(), mockRoadmap.getId())).thenReturn(5L);

        DashboardResponseDto dashboard = progressService.getStudentDashboard(userId);

        assertNotNull(dashboard);
        assertEquals(5, dashboard.getCompletedTopics());
        assertEquals(1, dashboard.getCompletedSheets());
        assertEquals(50.0, dashboard.getRoadmapProgress());
        assertEquals(3, dashboard.getCurrentStreak());
        assertEquals(7, dashboard.getWeeklyProgress().size());
    }

    @Test
    void updateActivityAndStreak_ShouldIncrementStreak_WhenLastActiveWasYesterday() {
        when(studentProfileRepository.findByUserId(userId)).thenReturn(Optional.of(student));
        when(progressRepository.findByStudentId(student.getId())).thenReturn(Optional.of(progress));
        when(progressRepository.save(any(Progress.class))).thenReturn(progress);
        when(studentProfileRepository.save(any(StudentProfile.class))).thenReturn(student);

        progressService.updateActivityAndStreak(userId);

        assertEquals(4, progress.getCurrentStreak());
        assertEquals(4, student.getStreak());
        assertNotNull(progress.getLastActive());
        verify(progressRepository, times(1)).save(progress);
    }

    @Test
    void updateActivityAndStreak_ShouldResetStreak_WhenLastActiveWasBeforeYesterday() {
        progress.setLastActive(LocalDateTime.now().minusDays(3)); // 3 days ago
        when(studentProfileRepository.findByUserId(userId)).thenReturn(Optional.of(student));
        when(progressRepository.findByStudentId(student.getId())).thenReturn(Optional.of(progress));
        when(progressRepository.save(any(Progress.class))).thenReturn(progress);
        when(studentProfileRepository.save(any(StudentProfile.class))).thenReturn(student);

        progressService.updateActivityAndStreak(userId);

        assertEquals(1, progress.getCurrentStreak());
        assertEquals(1, student.getStreak());
    }
}
