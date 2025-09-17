package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Option;
import lombok.Data;

import java.util.List;
@Data
public class QuestionDto {
    private Long questionId;
    private String questionText;
    private List<OptionsDto> optionsDto;

    public QuestionDto(Long questionId, String questionText, List<OptionsDto> optionsDto) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.optionsDto = optionsDto;
    }

    public QuestionDto() {}

    public Long getQuestionId() {return questionId;}
    public void setQuestionId(Long questionId) {this.questionId = questionId;}

    public String getQuestionText() {return questionText;}
    public void setQuestionText(String questionText) {this.questionText = questionText;}

    public List<OptionsDto> getOptionsDto() {return optionsDto;}
    public void setOptionsDto(List<OptionsDto> optionsDto) {this.optionsDto = optionsDto;}
}
