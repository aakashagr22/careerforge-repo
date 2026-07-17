package com.careerforge.student.entity;

import com.careerforge.common.entity.BaseEntity;
import com.careerforge.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "student_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentProfile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "branch")
    private String branch;

    @Column(name = "section")
    private String section;

    @Column(name = "college")
    private String college;

    @Column(name = "enrollment_no", unique = true)
    private String enrollmentNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "preferred_language")
    private Language preferredLanguage;

    @Enumerated(EnumType.STRING)
    @Column(name = "target_role")
    private TargetRole targetRole;

    @Builder.Default
    @Column(name = "communication_track_enabled", nullable = false)
    private boolean communicationTrackEnabled = false;

    @Builder.Default
    @Column(name = "streak", nullable = false)
    private Integer streak = 0;

    @Column(name = "profile_image")
    private String profileImage;
}
