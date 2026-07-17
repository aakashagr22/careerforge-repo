package com.careerforge.analytics.service.impl;

import com.careerforge.analytics.dto.AdminDashboardStatsDto;
import com.careerforge.analytics.service.AnalyticsService;
import com.careerforge.resource.repository.ResourceRepository;
import com.careerforge.sheet.repository.SheetRepository;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.entity.Role;
import com.careerforge.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
public class AnalyticsServiceImpl implements AnalyticsService {

    private final UserRepository userRepository;
    private final StudentProfileRepository studentProfileRepository;
    private final SheetRepository sheetRepository;
    private final ResourceRepository resourceRepository;

    public AnalyticsServiceImpl(UserRepository userRepository,
                                StudentProfileRepository studentProfileRepository,
                                SheetRepository sheetRepository,
                                ResourceRepository resourceRepository) {
        this.userRepository = userRepository;
        this.studentProfileRepository = studentProfileRepository;
        this.sheetRepository = sheetRepository;
        this.resourceRepository = resourceRepository;
    }

    @Override
    public AdminDashboardStatsDto getAdminDashboardStats() {
        log.info("Fetching admin dashboard analytics stats.");

        long totalStudents = studentProfileRepository.count();
        long activeStudents = userRepository.countByRoleAndActiveTrue(Role.STUDENT);
        long totalSheets = sheetRepository.count();
        long totalResources = resourceRepository.count();
        double averageStreak = studentProfileRepository.getAverageStreak();

        List<Object[]> branchResults = studentProfileRepository.getBranchDistribution();
        Map<String, Long> branchMap = branchResults.stream()
                .collect(Collectors.toMap(
                        res -> res[0] != null ? (String) res[0] : "Not Specified",
                        res -> (Long) res[1],
                        Long::sum
                ));

        List<Object[]> collegeResults = studentProfileRepository.getCollegeDistribution();
        Map<String, Long> collegeMap = collegeResults.stream()
                .collect(Collectors.toMap(
                        res -> res[0] != null ? (String) res[0] : "Not Specified",
                        res -> (Long) res[1],
                        Long::sum
                ));

        return AdminDashboardStatsDto.builder()
                .totalStudents(totalStudents)
                .activeStudents(activeStudents)
                .totalSheets(totalSheets)
                .totalResources(totalResources)
                .averageStreak(averageStreak)
                .studentDistributionByBranch(branchMap)
                .studentDistributionByCollege(collegeMap)
                .build();
    }
}
