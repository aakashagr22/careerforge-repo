package com.careerforge.roadmap.entity;

import com.careerforge.common.entity.BaseEntity;
import com.careerforge.student.entity.Language;
import com.careerforge.student.entity.TargetRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roadmaps", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"semester", "language", "target_role"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Roadmap extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "semester", nullable = false)
    private Integer semester;

    @Column(name = "months_remaining", nullable = false)
    private Integer monthsRemaining;

    @Enumerated(EnumType.STRING)
    @Column(name = "language", nullable = false)
    private Language language;

    @Enumerated(EnumType.STRING)
    @Column(name = "target_role", nullable = false)
    private TargetRole targetRole;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "roadmap", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<RoadmapPhase> phases = new ArrayList<>();
}
