package com.careerforge.roadmap.mapper;

import com.careerforge.roadmap.dto.QuestionDto;
import com.careerforge.roadmap.dto.QuestionLinkDto;
import com.careerforge.roadmap.dto.RoadmapSectionQuestionDto;
import com.careerforge.roadmap.entity.Question;
import com.careerforge.roadmap.entity.QuestionLink;
import com.careerforge.roadmap.entity.RoadmapSectionQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    @Mapping(source = "id", target = "sectionQuestionId")
    @Mapping(source = "question.id", target = "questionId")
    @Mapping(source = "question.title", target = "title")
    @Mapping(source = "question.description", target = "description")
    @Mapping(source = "question.difficulty", target = "difficulty")
    @Mapping(source = "question.links", target = "links")
    @Mapping(target = "completed", ignore = true)
    @Mapping(target = "revisionMarked", ignore = true)
    @Mapping(target = "note", ignore = true)
    RoadmapSectionQuestionDto toSectionQuestionDto(RoadmapSectionQuestion rsq);

    @Mapping(source = "question.id", target = "questionId")
    @Mapping(source = "question.title", target = "title")
    @Mapping(source = "question.description", target = "description")
    @Mapping(source = "question.difficulty", target = "difficulty")
    @Mapping(source = "question.links", target = "links")
    @Mapping(target = "sectionQuestionId", ignore = true)
    @Mapping(target = "completed", ignore = true)
    @Mapping(target = "revisionMarked", ignore = true)
    @Mapping(target = "note", ignore = true)
    RoadmapSectionQuestionDto toQuestionDtoOnly(Question question);

    QuestionDto toDto(Question question);

    QuestionLinkDto toLinkDto(QuestionLink link);

    List<QuestionLinkDto> toLinkDtoList(List<QuestionLink> links);
}
