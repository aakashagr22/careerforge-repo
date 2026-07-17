package com.careerforge.notification.mapper;

import com.careerforge.notification.dto.NotificationDto;
import com.careerforge.notification.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    @Mapping(source = "student.id", target = "studentId")
    NotificationDto toDto(Notification notification);

    @Mapping(target = "student", ignore = true)
    Notification toEntity(NotificationDto dto);
}
