package com.careerforge.roadmap.entity;

import com.careerforge.common.entity.BaseEntity;
import com.careerforge.student.entity.TargetRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roadmaps")
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

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Enumerated(EnumType.STRING)
    @Column(name = "target_roles", columnDefinition = "varchar(50)[]", nullable = false)
    private List<TargetRole> targetRoles = new ArrayList<>();

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "roadmap", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<RoadmapPhase> phases = new ArrayList<>();
}
