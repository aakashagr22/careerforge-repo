package com.careerforge.progress.entity;

import com.careerforge.common.entity.BaseEntity;
import com.careerforge.student.entity.StudentProfile;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "student_progress")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Progress extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false, unique = true)
    private StudentProfile student;

    @Builder.Default
    @Column(name = "completed_sheets", nullable = false)
    private Integer completedSheets = 0;

    @Builder.Default
    @Column(name = "completed_topics", nullable = false)
    private Integer completedTopics = 0;

    @Builder.Default
    @Column(name = "roadmap_progress", nullable = false)
    private Double roadmapProgress = 0.0;

    @Builder.Default
    @Column(name = "current_streak", nullable = false)
    private Integer currentStreak = 0;

    @Column(name = "last_active")
    private LocalDateTime lastActive;
}
