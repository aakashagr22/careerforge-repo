package com.careerforge.chat.repository;

import com.careerforge.chat.entity.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, UUID> {

    Page<ChatMessage> findByChatRoomIdAndDeletedFalseOrderByCreatedAtDesc(UUID chatRoomId, Pageable pageable);

    Page<ChatMessage> findByConversationIdAndDeletedFalseOrderByCreatedAtDesc(UUID conversationId, Pageable pageable);

    long countByChatRoomIdAndDeletedFalse(UUID chatRoomId);

    @Query("SELECT COUNT(DISTINCT m.sender.id) FROM ChatMessage m WHERE m.chatRoom.id = :roomId AND m.deleted = false")
    long countDistinctSendersByChatRoomId(@Param("roomId") UUID roomId);
}
