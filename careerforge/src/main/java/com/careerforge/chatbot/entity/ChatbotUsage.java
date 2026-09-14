package com.careerforge.chatbot.entity;

import com.careerforge.common.entity.BaseEntity;
import com.careerforge.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "chatbot_usage", uniqueConstraints = {
        @UniqueConstraint(name = "uq_chatbot_user_date", columnNames = {"user_id", "usage_date"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatbotUsage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "usage_date", nullable = false)
    private LocalDate usageDate;

    @Column(name = "query_count", nullable = false)
    @Builder.Default
    private int queryCount = 0;

    @Column(name = "last_query_at", nullable = false)
    private LocalDateTime lastQueryAt;
}
