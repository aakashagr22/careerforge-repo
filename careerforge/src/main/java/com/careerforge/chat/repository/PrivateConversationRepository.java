package com.careerforge.chat.repository;

import com.careerforge.chat.entity.PrivateConversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrivateConversationRepository extends JpaRepository<PrivateConversation, UUID> {

    @Query("SELECT pc FROM PrivateConversation pc WHERE " +
            "(pc.userOne.id = :userId OR pc.userTwo.id = :userId) " +
            "ORDER BY pc.createdAt DESC")
    List<PrivateConversation> findAllByUserId(@Param("userId") UUID userId);

    @Query("SELECT pc FROM PrivateConversation pc WHERE " +
            "(pc.userOne.id = :userOneId AND pc.userTwo.id = :userTwoId) OR " +
            "(pc.userOne.id = :userTwoId AND pc.userTwo.id = :userOneId)")
    Optional<PrivateConversation> findByUserPair(
            @Param("userOneId") UUID userOneId,
            @Param("userTwoId") UUID userTwoId);
}
