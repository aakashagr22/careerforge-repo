package com.careerforge.chat.mapper;

import com.careerforge.chat.dto.response.ChatMessageResponse;
import com.careerforge.chat.dto.response.ChatRoomResponse;
import com.careerforge.chat.dto.response.RoomMemberResponse;
import com.careerforge.chat.entity.ChatMessage;
import com.careerforge.chat.entity.ChatRoom;
import com.careerforge.chat.entity.RoomMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    @Mapping(target = "memberCount", ignore = true)
    @Mapping(source = "roomType", target = "roomType")
    ChatRoomResponse toRoomResponse(ChatRoom chatRoom);

    @Mapping(source = "chatRoom.id", target = "chatRoomId")
    @Mapping(source = "conversation.id", target = "conversationId")
    @Mapping(source = "sender.id", target = "senderId")
    @Mapping(source = "sender.firstName", target = "senderFirstName")
    @Mapping(source = "sender.lastName", target = "senderLastName")
    @Mapping(source = "sender.email", target = "senderEmail")
    @Mapping(source = "messageType", target = "messageType")
    ChatMessageResponse toMessageResponse(ChatMessage chatMessage);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.firstName", target = "firstName")
    @Mapping(source = "user.lastName", target = "lastName")
    @Mapping(source = "user.email", target = "email")
    RoomMemberResponse toMemberResponse(RoomMember roomMember);
}
