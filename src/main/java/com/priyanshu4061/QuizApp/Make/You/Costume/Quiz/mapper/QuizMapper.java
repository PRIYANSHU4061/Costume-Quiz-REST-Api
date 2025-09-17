package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.mapper;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto.QuizDto;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Quiz;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class QuizMapper {

    // Entity → DTO
    public static QuizDto toDto(Quiz quiz) {
        QuizDto dto = new QuizDto();
        dto.setQuizId(quiz.getQuizId());
        dto.setTitle(quiz.getTitle());
        dto.setDescription(quiz.getDescription());

        if (quiz.getQuestions() != null) {
            dto.setQuestionDto(
                    quiz.getQuestions().stream()
                            .map(QuestionMapper::toDto)
                            .collect(Collectors.toList())
            );
        } else {
            dto.setQuestionDto(new ArrayList<>());
        }

        return dto;
    }

    // DTO → Entity
    public static Quiz toEntity(QuizDto dto) {
        Quiz quiz = new Quiz();
        quiz.setQuizId(dto.getQuizId());
        quiz.setTitle(dto.getTitle());
        quiz.setDescription(dto.getDescription());

        if (dto.getQuestionDto() != null) {
            quiz.setQuestions(
                    dto.getQuestionDto().stream()
                            .map(QuestionMapper::toEntity)
                            .collect(Collectors.toList())
            );
            // set back-reference in each question
            quiz.getQuestions().forEach(q -> q.setQuiz(quiz));
        } else {
            quiz.setQuestions(new ArrayList<>());
        }

        return quiz;
    }
}
