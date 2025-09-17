package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(nullable = false)
    private String questionText;

    @ManyToOne()
    @JoinColumn(name = "quiz_Id", nullable = false)
    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options =  new ArrayList<>();

    public Question(Long questionId, String questionText, Quiz quiz) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.quiz = quiz;
    }

    public Question() {}

    public Long getQuestionId() {return questionId;}
    public void setQuestionId(Long questionId) {this.questionId = questionId;}

    public String getQuestionText() {return questionText;}
    public void setQuestionText(String questionText) {this.questionText = questionText;}

    public Quiz getQuiz() {return quiz;}
    public void setQuiz(Quiz quiz) {this.quiz = quiz;}

    public List<Option> getOptions() {return options;}
    public void setOptions(List<Option> options) {this.options = options;}
}
