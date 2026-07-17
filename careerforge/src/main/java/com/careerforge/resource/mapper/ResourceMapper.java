package com.careerforge.resource.mapper;

import com.careerforge.resource.dto.ResourceDto;
import com.careerforge.resource.entity.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResourceMapper {

    @Mapping(source = "createdBy.id", target = "createdById")
    @Mapping(expression = "java(resource.getCreatedBy().getFirstName() + \" \" + resource.getCreatedBy().getLastName())", target = "createdByName")
    ResourceDto toDto(Resource resource);
}
