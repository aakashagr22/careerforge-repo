package com.careerforge.roadmap.entity;

import com.careerforge.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roadmap_sections", uniqueConstraints = {
    @UniqueConstraint(name = "uq_section_id_roadmap", columnNames = {"id", "roadmap_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoadmapSection extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roadmap_id", nullable = false)
    private Roadmap roadmap;

    @Column(name = "roadmap_id", insertable = false, updatable = false)
    private UUID roadmapId;

    @Column(name = "parent_id")
    private UUID parentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "parent_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "roadmap_id", referencedColumnName = "roadmap_id", insertable = false, updatable = false)
    })
    private RoadmapSection parentSection;

    @OneToMany(mappedBy = "parentSection", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("position ASC")
    @Builder.Default
    private List<RoadmapSection> subSections = new ArrayList<>();

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "position", nullable = false)
    private Integer position;
}
