package com.careerforge.chat.repository;

import com.careerforge.chat.entity.MutedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MutedUserRepository extends JpaRepository<MutedUser, UUID> {

    Optional<MutedUser> findByChatRoomIdAndUserId(UUID chatRoomId, UUID userId);

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM MutedUser m " +
            "WHERE m.chatRoom.id = :roomId AND m.user.id = :userId " +
            "AND (m.expiresAt IS NULL OR m.expiresAt > :now)")
    boolean isUserMutedInRoom(
            @Param("roomId") UUID roomId,
            @Param("userId") UUID userId,
            @Param("now") LocalDateTime now);

    void deleteByChatRoomIdAndUserId(UUID chatRoomId, UUID userId);
}
