package com.careerforge.sheet.mapper;

import com.careerforge.sheet.dto.SheetTopicDto;
import com.careerforge.sheet.entity.SheetTopic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SheetTopicMapper {

    @Mapping(source = "sheet.id", target = "sheetId")
    SheetTopicDto toDto(SheetTopic topic);

    @Mapping(target = "sheet", ignore = true)
    SheetTopic toEntity(SheetTopicDto dto);
}
