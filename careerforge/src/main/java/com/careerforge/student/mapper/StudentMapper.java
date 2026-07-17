package com.careerforge.student.mapper;

import com.careerforge.student.dto.StudentProfileResponse;
import com.careerforge.student.entity.StudentProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.firstName", target = "firstName")
    @Mapping(source = "user.lastName", target = "lastName")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.role", target = "role")
    @Mapping(source = "user.active", target = "active")
    StudentProfileResponse toResponse(StudentProfile studentProfile);
}
