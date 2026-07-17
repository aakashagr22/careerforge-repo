package com.careerforge.roadmap.mapper;

import com.careerforge.roadmap.dto.RoadmapDto;
import com.careerforge.roadmap.entity.Roadmap;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoadmapMapper {
    RoadmapDto toDto(Roadmap roadmap);
    Roadmap toEntity(RoadmapDto dto);
}
