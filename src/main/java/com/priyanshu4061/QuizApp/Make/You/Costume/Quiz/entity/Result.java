package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;
    private int score;
    private LocalDateTime localDateTime;

    @ManyToOne()
    @JoinColumn(name = "used_Id", nullable = false)
    private User user;

    @ManyToOne()
    @JoinColumn(name = "quiz_Id", nullable = false)
    private Quiz quiz;

    public Result(int score, LocalDateTime localDateTime, User user, Quiz quiz) {
        this.score = score;
        this.localDateTime = localDateTime;
        this.user = user;
        this.quiz = quiz;
    }

    public Result() {
    }

    public Long getResultId() {return resultId;}
    public void setResultId(Long resultId) {this.resultId = resultId;}

    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}

    public LocalDateTime getLocalDateTime() {return localDateTime;}
    public void setLocalDateTime(LocalDateTime localDateTime) {this.localDateTime = localDateTime;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    public Quiz getQuiz() {return quiz;}
    public void setQuiz(Quiz quiz) {this.quiz = quiz;}


}
