package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto;

import lombok.Data;

@Data
public class AnswerDto {
    private Long questionId;
    private Long selectedOptionId;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getSelectedOptionId() {
        return selectedOptionId;
    }

    public void setSelectedOptionId(Long selectedOptionId) {
        this.selectedOptionId = selectedOptionId;
    }
}
