package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.mapper;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto.QuestionDto;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Question;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class QuestionMapper {
    public static QuestionDto toDto(Question question) {
        QuestionDto dto = new QuestionDto();
        dto.setQuestionId(question.getQuestionId());
        dto.setQuestionText(question.getQuestionText());
        if (question.getOptions() != null) {
            dto.setOptionsDto(
                    question.getOptions().stream()
                            .map(OptionMapper::toDto)
                            .collect(Collectors.toList())
            );
        } else {
            dto.setOptionsDto(new ArrayList<>());
        }
        return dto;
    }

    public static Question toEntity(QuestionDto dto) {
        Question question = new Question();
        question.setQuestionId(dto.getQuestionId());
        question.setQuestionText(dto.getQuestionText());
        if (dto.getOptionsDto() != null) {
            question.setOptions(
                    dto.getOptionsDto().stream()
                            .map(OptionMapper::toEntity)
                            .collect(Collectors.toList())
            );
            question.getOptions().forEach(opt -> opt.setQuestion(question));
        } else {
            question.setOptions(new ArrayList<>());
        }
        return question;
    }
}
