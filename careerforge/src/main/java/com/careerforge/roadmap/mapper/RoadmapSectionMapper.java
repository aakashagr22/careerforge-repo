package com.careerforge.roadmap.mapper;

import com.careerforge.roadmap.dto.RoadmapSectionTreeDto;
import com.careerforge.roadmap.entity.RoadmapSection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoadmapSectionMapper {

    @Mapping(target = "children", ignore = true)
    @Mapping(target = "questions", ignore = true)
    RoadmapSectionTreeDto toTreeDto(RoadmapSection section);
}
