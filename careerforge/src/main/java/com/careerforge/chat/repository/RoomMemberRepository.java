package com.careerforge.chat.repository;

import com.careerforge.chat.entity.RoomMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomMemberRepository extends JpaRepository<RoomMember, UUID> {

    List<RoomMember> findByChatRoomId(UUID chatRoomId);

    Optional<RoomMember> findByChatRoomIdAndUserId(UUID chatRoomId, UUID userId);

    boolean existsByChatRoomIdAndUserId(UUID chatRoomId, UUID userId);

    long countByChatRoomId(UUID chatRoomId);

    void deleteByChatRoomIdAndUserId(UUID chatRoomId, UUID userId);
}
