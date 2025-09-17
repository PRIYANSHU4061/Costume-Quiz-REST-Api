package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;
    private  String title;
    private String description;

    @OneToMany(mappedBy = "quiz" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    public Quiz() {
    }

    public Quiz(Long quizId, String title, String description) {
        this.quizId = quizId;
        this.title = title;
        this.description = description;
    }

    public Long getQuizId() {return quizId;}
    public void setQuizId(Long quizId) {this.quizId = quizId;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public List<Question> getQuestions() {return questions;}
    public void setQuestions(List<Question> questions) {this.questions = questions;}
}
