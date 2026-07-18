package com.careerforge.roadmap.entity;

import com.careerforge.common.entity.BaseEntity;
import com.careerforge.student.entity.StudentProfile;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_roadmap_question_progress")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRoadmapQuestionProgress extends BaseEntity {

    @EmbeddedId
    private StudentRoadmapQuestionProgressId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
    @JoinColumn(name = "student_id", nullable = false)
    private StudentProfile student;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roadmapSectionQuestionId")
    @JoinColumn(name = "roadmap_section_question_id", nullable = false)
    private RoadmapSectionQuestion roadmapSectionQuestion;

    @Column(name = "completed", nullable = false)
    @Builder.Default
    private boolean completed = false;

    @Column(name = "revision_marked", nullable = false)
    @Builder.Default
    private boolean revisionMarked = false;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;
}
