package com.careerforge.resource.entity;

import com.careerforge.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "resource_folders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceFolder extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ResourceFolder parentFolder;

    @Column(name = "parent_id", insertable = false, updatable = false)
    private UUID parentId;

    @OneToMany(mappedBy = "parentFolder", fetch = FetchType.LAZY)
    private List<ResourceFolder> childFolders = new ArrayList<>();

    @OneToMany(mappedBy = "folder", fetch = FetchType.LAZY)
    private List<Resource> resources = new ArrayList<>();
}
