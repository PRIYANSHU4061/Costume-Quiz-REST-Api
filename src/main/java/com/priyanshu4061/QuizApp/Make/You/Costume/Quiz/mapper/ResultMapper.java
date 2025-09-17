package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.mapper;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto.ResultDto;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Result;

public class ResultMapper {

    public static ResultDto toDto(Result result) {
        if (result == null) {
            return null;
        }
        return new ResultDto(
                result.getResultId(),
                result.getUser().getUserId(),
                result.getQuiz().getQuizId(),
                result.getScore(),
                result.getLocalDateTime()
        );
    }

    public static Result toEntity(ResultDto dto) {
        if (dto == null) {
            return null;
        }
        Result result = new Result();
        result.setResultId(dto.getResultId());
        result.setScore(dto.getScore());
        result.setLocalDateTime(dto.getLocalDateTime());
        return result;
    }
}
