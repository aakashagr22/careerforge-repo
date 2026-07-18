package com.careerforge.roadmap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRoadmapQuestionProgressId implements Serializable {

    @Column(name = "student_id")
    private UUID studentId;

    @Column(name = "roadmap_section_question_id")
    private UUID roadmapSectionQuestionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRoadmapQuestionProgressId that = (StudentRoadmapQuestionProgressId) o;
        return Objects.equals(studentId, that.studentId) &&
               Objects.equals(roadmapSectionQuestionId, that.roadmapSectionQuestionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, roadmapSectionQuestionId);
    }
}
