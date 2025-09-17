package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto;

public class OptionsDto {
    private Long optionId;
    private String optionText;
    private boolean correct;

    public OptionsDto(Long optionId, String optionText, boolean correct) {
        this.optionId = optionId;
        this.optionText = optionText;
        this.correct = correct;
    }

    public OptionsDto() {
    }

    public Long getOptionId() {return optionId;}
    public void setOptionId(Long optionId) {this.optionId = optionId;}

    public String getOptionText() {return optionText;}
    public void setOptionText(String optionText) {this.optionText = optionText;}

    public boolean isCorrect() {return correct;}
    public void setCorrect(boolean correct) {this.correct = correct;}
}
