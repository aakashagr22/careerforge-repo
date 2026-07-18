package com.careerforge.sheet;

import com.careerforge.common.entity.Difficulty;
import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.sheet.dto.*;
import com.careerforge.sheet.entity.Sheet;
import com.careerforge.sheet.entity.SheetTopic;
import com.careerforge.sheet.entity.StudentSheetProgress;
import com.careerforge.sheet.mapper.SheetMapper;
import com.careerforge.sheet.mapper.SheetTopicMapper;
import com.careerforge.sheet.repository.SheetRepository;
import com.careerforge.sheet.repository.SheetTopicRepository;
import com.careerforge.sheet.repository.StudentSheetProgressRepository;
import com.careerforge.sheet.service.impl.SheetServiceImpl;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SheetServiceTest {

    @Mock
    private SheetRepository sheetRepository;

    @Mock
    private SheetTopicRepository sheetTopicRepository;

    @Mock
    private StudentSheetProgressRepository progressRepository;

    @Mock
    private StudentProfileRepository studentProfileRepository;

    @Mock
    private SheetMapper sheetMapper;

    @Mock
    private SheetTopicMapper sheetTopicMapper;

    @Mock
    private com.careerforge.progress.service.ProgressService progressService;

    @Mock
    private org.springframework.context.ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private SheetServiceImpl sheetService;

    private Sheet sheet;
    private SheetDto sheetDto;
    private CreateSheetRequest createSheetRequest;
    private UpdateSheetRequest updateSheetRequest;

    private SheetTopic topic;
    private SheetTopicDto topicDto;
    private CreateSheetTopicRequest createTopicRequest;
    private UpdateSheetTopicRequest updateTopicRequest;

    private StudentProfile student;
    private StudentSheetProgress progress;

    @BeforeEach
    void setUp() {
        UUID sheetId = UUID.randomUUID();
        UUID topicId = UUID.randomUUID();
        UUID studentId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();

        sheet = Sheet.builder()
                .id(sheetId)
                .title("DSA Prep Sheet")
                .description("Top coding interview problems")
                .category("DSA")
                .build();

        sheetDto = SheetDto.builder()
                .id(sheetId)
                .title("DSA Prep Sheet")
                .description("Top coding interview problems")
                .category("DSA")
                .build();

        createSheetRequest = CreateSheetRequest.builder()
                .title("DSA Prep Sheet")
                .description("Top coding interview problems")
                .category("DSA")
                .build();

        updateSheetRequest = UpdateSheetRequest.builder()
                .title("DSA Prep Sheet (Updated)")
                .description("Updated description")
                .category("Algorithms")
                .build();

        topic = SheetTopic.builder()
                .id(topicId)
                .title("Two Sum")
                .description("Find two numbers that add up to target")
                .difficulty(Difficulty.EASY)
                .orderIndex(1)
                .sheet(sheet)
                .build();

        topicDto = SheetTopicDto.builder()
                .id(topicId)
                .title("Two Sum")
                .description("Find two numbers that add up to target")
                .difficulty(Difficulty.EASY)
                .orderIndex(1)
                .sheetId(sheetId)
                .build();

        createTopicRequest = CreateSheetTopicRequest.builder()
                .title("Two Sum")
                .description("Find two numbers that add up to target")
                .difficulty(Difficulty.EASY)
                .orderIndex(1)
                .sheetId(sheetId)
                .build();

        updateTopicRequest = UpdateSheetTopicRequest.builder()
                .title("Two Sum (Updated)")
                .description("Updated description")
                .difficulty(Difficulty.MEDIUM)
                .orderIndex(1)
                .build();

        student = StudentProfile.builder()
                .id(studentId)
                .user(User.builder().id(userId).build())
                .streak(0)
                .build();

        progress = StudentSheetProgress.builder()
                .id(UUID.randomUUID())
                .student(student)
                .sheetTopic(topic)
                .completed(true)
                .build();
    }

    // ======================== Sheet Tests ========================

    @Test
    void createSheet_ShouldSaveAndReturnDto() {
        when(sheetRepository.save(any(Sheet.class))).thenReturn(sheet);
        when(sheetMapper.toDto(sheet)).thenReturn(sheetDto);

        SheetDto result = sheetService.createSheet(createSheetRequest);

        assertNotNull(result);
        assertEquals("DSA Prep Sheet", result.getTitle());
        verify(sheetRepository, times(1)).save(any(Sheet.class));
    }

    @Test
    void updateSheet_ShouldModifyAndReturnDto_WhenExists() {
        when(sheetRepository.findById(sheet.getId())).thenReturn(Optional.of(sheet));
        when(sheetRepository.save(any(Sheet.class))).thenReturn(sheet);
        when(sheetMapper.toDto(sheet)).thenReturn(sheetDto);

        SheetDto result = sheetService.updateSheet(sheet.getId(), updateSheetRequest);

        assertNotNull(result);
        assertEquals("DSA Prep Sheet (Updated)", sheet.getTitle());
        verify(sheetRepository, times(1)).save(sheet);
    }

    @Test
    void deleteSheet_ShouldRemove_WhenExists() {
        when(sheetRepository.findById(sheet.getId())).thenReturn(Optional.of(sheet));
        doNothing().when(sheetRepository).delete(sheet);

        assertDoesNotThrow(() -> sheetService.deleteSheet(sheet.getId()));
        verify(sheetRepository, times(1)).delete(sheet);
    }

    @Test
    void getSheetById_ShouldReturnDto_WhenExists() {
        when(sheetRepository.findById(sheet.getId())).thenReturn(Optional.of(sheet));
        when(sheetMapper.toDto(sheet)).thenReturn(sheetDto);

        SheetDto result = sheetService.getSheetById(sheet.getId());

        assertNotNull(result);
        assertEquals(sheet.getId(), result.getId());
    }

    // ======================== Topic Tests ========================

    @Test
    void createSheetTopic_ShouldSaveAndReturnDto_WhenSheetExists() {
        when(sheetRepository.findById(sheet.getId())).thenReturn(Optional.of(sheet));
        when(sheetTopicRepository.save(any(SheetTopic.class))).thenReturn(topic);
        when(sheetTopicMapper.toDto(topic)).thenReturn(topicDto);

        SheetTopicDto result = sheetService.createSheetTopic(createTopicRequest);

        assertNotNull(result);
        assertEquals("Two Sum", result.getTitle());
        verify(sheetTopicRepository, times(1)).save(any(SheetTopic.class));
    }

    @Test
    void updateSheetTopic_ShouldModifyAndReturnDto_WhenExists() {
        when(sheetTopicRepository.findById(topic.getId())).thenReturn(Optional.of(topic));
        when(sheetTopicRepository.save(any(SheetTopic.class))).thenReturn(topic);
        when(sheetTopicMapper.toDto(topic)).thenReturn(topicDto);

        SheetTopicDto result = sheetService.updateSheetTopic(topic.getId(), updateTopicRequest);

        assertNotNull(result);
        assertEquals("Two Sum (Updated)", topic.getTitle());
        assertEquals(Difficulty.MEDIUM, topic.getDifficulty());
    }

    @Test
    void markTopicCompleted_ShouldCreateOrUpdateProgress() {
        when(studentProfileRepository.findByUserId(student.getUser().getId())).thenReturn(Optional.of(student));
        when(sheetTopicRepository.findById(topic.getId())).thenReturn(Optional.of(topic));
        when(progressRepository.findByStudentIdAndSheetTopicId(student.getId(), topic.getId())).thenReturn(Optional.empty());
        when(progressRepository.save(any(StudentSheetProgress.class))).thenReturn(progress);

        StudentSheetProgressDto result = sheetService.markTopicCompleted(student.getUser().getId(), topic.getId(), true);

        assertNotNull(result);
        assertTrue(result.isCompleted());
        verify(progressRepository, times(1)).save(any(StudentSheetProgress.class));
    }

    @Test
    void getProgressPercentage_ShouldCalculateCorrectly() {
        when(studentProfileRepository.findByUserId(student.getUser().getId())).thenReturn(Optional.of(student));
        when(sheetTopicRepository.countBySheetId(sheet.getId())).thenReturn(10L);
        when(progressRepository.countCompletedByStudentIdAndSheetId(student.getId(), sheet.getId())).thenReturn(4L);

        double percentage = sheetService.getProgressPercentage(student.getUser().getId(), sheet.getId());

        assertEquals(40.0, percentage);
    }
}
