package com.careerforge.user.mapper;

import com.careerforge.user.dto.UserDto;
import com.careerforge.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    @Mapping(target = "password", ignore = true)
    User toEntity(UserDto userDto);
}
