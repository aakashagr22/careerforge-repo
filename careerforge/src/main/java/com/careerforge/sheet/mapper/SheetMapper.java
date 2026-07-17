package com.careerforge.sheet.mapper;

import com.careerforge.sheet.dto.SheetDto;
import com.careerforge.sheet.entity.Sheet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SheetMapper {
    SheetDto toDto(Sheet sheet);
    Sheet toEntity(SheetDto dto);
}
