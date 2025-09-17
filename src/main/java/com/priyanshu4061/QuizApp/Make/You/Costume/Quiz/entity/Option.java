package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    private String optionText;
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_Id", nullable = false)
    private Question question;

    public Option() {
    }

    public Option(Long optionId, String optionText, boolean correct, Question question) {
        this.optionId = optionId;
        this.optionText = optionText;
        this.correct = correct;
        this.question = question;
    }

    public Long getOptionId() {return optionId;}
    public void setOptionId(Long optionId) {this.optionId = optionId;}

    public String getOptionText() {return optionText;}
    public void setOptionText(String text) {this.optionText = text;}

    public boolean isCorrect() {return correct;}
    public void setCorrect(boolean correct) { this.correct = correct; }

    public Question getQuestion() {return question;}
    public void setQuestion(Question question) {this.question = question;}
}
