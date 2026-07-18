package com.careerforge.analytics;

import com.careerforge.analytics.dto.AdminDashboardStatsDto;
import com.careerforge.analytics.service.impl.AnalyticsServiceImpl;
import com.careerforge.resource.repository.ResourceRepository;
import com.careerforge.sheet.repository.SheetRepository;
import com.careerforge.student.repository.StudentProfileRepository;
import com.careerforge.user.entity.Role;
import com.careerforge.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnalyticsServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private StudentProfileRepository studentProfileRepository;

    @Mock
    private SheetRepository sheetRepository;

    @Mock
    private ResourceRepository resourceRepository;

    @InjectMocks
    private AnalyticsServiceImpl analyticsService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAdminDashboardStats_ShouldReturnAggregates() {
        Object[] branch1 = new Object[]{"Computer Science", 10L};
        Object[] branch2 = new Object[]{"Electrical Engineering", 5L};
        List<Object[]> branches = List.of(branch1, branch2);


        when(studentProfileRepository.count()).thenReturn(15L);
        when(userRepository.countByRoleAndActiveTrue(Role.STUDENT)).thenReturn(12L);
        when(sheetRepository.count()).thenReturn(3L);
        when(resourceRepository.count()).thenReturn(8L);
        when(studentProfileRepository.getAverageStreak()).thenReturn(4.5);
        when(studentProfileRepository.getBranchDistribution()).thenReturn(branches);

        AdminDashboardStatsDto result = analyticsService.getAdminDashboardStats();

        assertNotNull(result);
        assertEquals(15, result.getTotalStudents());
        assertEquals(12, result.getActiveStudents());
        assertEquals(3, result.getTotalSheets());
        assertEquals(8, result.getTotalResources());
        assertEquals(4.5, result.getAverageStreak());
        assertEquals(10L, result.getStudentDistributionByBranch().get("Computer Science"));
    }
}
