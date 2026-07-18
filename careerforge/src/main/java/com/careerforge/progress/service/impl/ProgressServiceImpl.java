package com.careerforge.progress.service.impl;

import com.careerforge.exception.ResourceNotFoundException;
import com.careerforge.progress.dto.DashboardResponseDto;
import com.careerforge.progress.dto.WeeklyProgressDto;
import com.careerforge.progress.entity.Progress;
import com.careerforge.progress.repository.ProgressRepository;
import com.careerforge.progress.service.ProgressService;
import com.careerforge.sheet.entity.Sheet;
import com.careerforge.sheet.entity.StudentSheetProgress;
import com.careerforge.sheet.repository.SheetRepository;
import com.careerforge.sheet.repository.SheetTopicRepository;
import com.careerforge.sheet.repository.StudentSheetProgressRepository;
import com.careerforge.student.entity.StudentProfile;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.roadmap.repository.RoadmapRepository;
import com.careerforge.roadmap.repository.RoadmapSectionQuestionRepository;
import com.careerforge.roadmap.repository.StudentRoadmapQuestionProgressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository progressRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final SheetRepository sheetRepository;
    private final SheetTopicRepository sheetTopicRepository;
    private final StudentSheetProgressRepository studentSheetProgressRepository;
    private final RoadmapRepository roadmapRepository;
    private final RoadmapSectionQuestionRepository roadmapSectionQuestionRepository;
    private final StudentRoadmapQuestionProgressRepository studentRoadmapQuestionProgressRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository,
                               StudentProfileRepository studentProfileRepository,
                               SheetRepository sheetRepository,
                               SheetTopicRepository sheetTopicRepository,
                               StudentSheetProgressRepository studentSheetProgressRepository,
                               RoadmapRepository roadmapRepository,
                               RoadmapSectionQuestionRepository roadmapSectionQuestionRepository,
                               StudentRoadmapQuestionProgressRepository studentRoadmapQuestionProgressRepository) {
        this.progressRepository = progressRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.sheetRepository = sheetRepository;
        this.sheetTopicRepository = sheetTopicRepository;
        this.studentSheetProgressRepository = studentSheetProgressRepository;
        this.roadmapRepository = roadmapRepository;
        this.roadmapSectionQuestionRepository = roadmapSectionQuestionRepository;
        this.studentRoadmapQuestionProgressRepository = studentRoadmapQuestionProgressRepository;
    }

    @Override
    public DashboardResponseDto getStudentDashboard(UUID studentUserId) {
        StudentProfile student = studentProfileRepository.findByUserId(studentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for user ID: " + studentUserId));

        // Get progress or initialize it
        Progress progress = progressRepository.findByStudentId(student.getId())
                .orElseGet(() -> {
                    Progress newProgress = Progress.builder()
                            .student(student)
                            .currentStreak(0)
                            .build();
                    return progressRepository.save(newProgress);
                });

        long completedTopics = studentSheetProgressRepository.countByStudentIdAndCompletedTrue(student.getId());

        // Calculate completed sheets (sheets where all topics are completed)
        List<Sheet> allSheets = sheetRepository.findAll();
        long completedSheetsCount = 0;
        for (Sheet sheet : allSheets) {
            long totalTopics = sheetTopicRepository.countBySheetId(sheet.getId());
            if (totalTopics > 0) {
                long completedInSheet = studentSheetProgressRepository.countCompletedByStudentIdAndSheetId(student.getId(), sheet.getId());
                if (totalTopics == completedInSheet) {
                    completedSheetsCount++;
                }
            }
        }

        // Calculate roadmap progress (completions / total roadmap questions available for student's active roadmap)
        long totalRoadmapQuestions = 0;
        long completedRoadmapQuestions = 0;
        
        if (student.getSemester() != null && student.getTargetRole() != null) {
            Optional<com.careerforge.roadmap.entity.Roadmap> roadmapOpt = roadmapRepository.findBySemesterAndTargetRole(
                    student.getSemester(),
                    student.getTargetRole().name()
            );
            if (roadmapOpt.isPresent()) {
                UUID roadmapId = roadmapOpt.get().getId();
                totalRoadmapQuestions = roadmapSectionQuestionRepository.findByRoadmapSectionRoadmapId(roadmapId).size();
                completedRoadmapQuestions = studentRoadmapQuestionProgressRepository
                        .countByStudentIdAndRoadmapSectionQuestionRoadmapSectionRoadmapIdAndCompletedTrue(student.getId(), roadmapId);
            }
        }
        
        double roadmapProgress = totalRoadmapQuestions > 0
                ? ((double) completedRoadmapQuestions / totalRoadmapQuestions) * 100.0
                : 0.0;

        // Fetch weekly progress (last 7 days counts)
        List<WeeklyProgressDto> weeklyProgress = calculateWeeklyProgress(student.getId());

        // Update progress cache values
        progress.setCompletedTopics((int) completedTopics);
        progress.setCompletedSheets((int) completedSheetsCount);
        progress.setRoadmapProgress(roadmapProgress);
        progressRepository.save(progress);

        return DashboardResponseDto.builder()
                .completedTopics(completedTopics)
                .completedSheets(completedSheetsCount)
                .roadmapProgress(roadmapProgress)
                .currentStreak(progress.getCurrentStreak())
                .weeklyProgress(weeklyProgress)
                .build();
    }

    @Override
    public void updateActivityAndStreak(UUID studentUserId) {
        StudentProfile student = studentProfileRepository.findByUserId(studentUserId)
                .orElseThrow(() -> new ResourceNotFoundException("Student profile not found for user ID: " + studentUserId));

        Progress progress = progressRepository.findByStudentId(student.getId())
                .orElseGet(() -> Progress.builder().student(student).currentStreak(0).build());

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastActive = progress.getLastActive();

        if (lastActive == null) {
            progress.setCurrentStreak(1);
        } else {
            long daysBetween = ChronoUnit.DAYS.between(lastActive.toLocalDate(), now.toLocalDate());
            if (daysBetween == 1) {
                // Active on consecutive day, increment streak
                progress.setCurrentStreak(progress.getCurrentStreak() + 1);
            } else if (daysBetween > 1) {
                // Streak broken, reset to 1
                progress.setCurrentStreak(1);
            }
            // If active on the same day, leave streak unchanged
        }

        progress.setLastActive(now);
        progressRepository.save(progress);

        // Sync streak with StudentProfile entity
        student.setStreak(progress.getCurrentStreak());
        studentProfileRepository.save(student);

        log.info("Updated activity and streak for student user: {}. Current streak: {}", studentUserId, progress.getCurrentStreak());
    }

    private List<WeeklyProgressDto> calculateWeeklyProgress(UUID studentId) {
        List<StudentSheetProgress> allProgress = studentSheetProgressRepository.findAllByStudentId(studentId);

        // Group completed items by date
        Map<LocalDate, Long> completionCountsByDate = allProgress.stream()
                .filter(p -> p.isCompleted() && p.getCompletedAt() != null)
                .collect(Collectors.groupingBy(
                        p -> p.getCompletedAt().toLocalDate(),
                        Collectors.counting()
                ));

        List<WeeklyProgressDto> weeklyProgress = new ArrayList<>();
        LocalDate today = LocalDate.now();

        // Collect stats for the last 7 days (ending today)
        for (int i = 6; i >= 0; i--) {
            LocalDate date = today.minusDays(i);
            long count = completionCountsByDate.getOrDefault(date, 0L);
            weeklyProgress.add(WeeklyProgressDto.builder()
                    .date(date)
                    .dayOfWeek(date.getDayOfWeek().name())
                    .completedCount(count)
                    .build());
        }

        return weeklyProgress;
    }
}
