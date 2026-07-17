package com.careerforge.roadmap.mapper;

import com.careerforge.roadmap.dto.RoadmapPhaseDto;
import com.careerforge.roadmap.entity.RoadmapPhase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoadmapPhaseMapper {

    @Mapping(source = "roadmap.id", target = "roadmapId")
    RoadmapPhaseDto toDto(RoadmapPhase phase);

    @Mapping(target = "roadmap", ignore = true)
    RoadmapPhase toEntity(RoadmapPhaseDto dto);
}
