package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuizDto {
    private Long quizId;
    private String title;
    private String description;
    private List<QuestionDto> questionDto;

    public QuizDto() {}

    public QuizDto(Long quizId, String text, String description, List<QuestionDto> questionDto) {
        this.quizId = quizId;
        this.title = text;
        this.description = description;
        this.questionDto = questionDto;
    }

    public Long getQuizId() {return quizId;}
    public void setQuizId(Long quizId) {this.quizId = quizId;}

    public String getTitle() {return title;}
    public void setTitle(String text) {this.title = text;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public List<QuestionDto> getQuestionDto() {return questionDto;}
    public void setQuestionDto(List<QuestionDto> questionDto) {this.questionDto = questionDto;}
}
