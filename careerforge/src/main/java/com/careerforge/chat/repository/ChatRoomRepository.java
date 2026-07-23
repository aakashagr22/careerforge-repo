package com.careerforge.chat.repository;

import com.careerforge.chat.entity.ChatRoom;
import com.careerforge.chat.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, UUID> {

    List<ChatRoom> findByRoomTypeAndActiveTrue(RoomType roomType);

    List<ChatRoom> findByActiveTrue();

    boolean existsByNameAndActiveTrue(String name);
}
