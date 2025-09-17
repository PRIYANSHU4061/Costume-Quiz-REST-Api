package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResultDto {
    private Long resultId;
    private Long userId;
    private String username;
    private Long quizId;
    private int score;
    private LocalDateTime localDateTime;

    public ResultDto(Long resultId, Long userId, Long quizId,  int score, LocalDateTime localDateTime) {
        this.resultId = resultId;
        this.userId = userId;
        this.quizId = quizId;
        this.score = score;
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {return localDateTime;}
    public void setLocalDateTime(LocalDateTime localDateTime) {this.localDateTime = localDateTime;}

    public ResultDto() {}

    public Long getResultId() {return resultId;}
    public void setResultId(Long resultId) {this.resultId = resultId;}

    public Long getUserId() {return userId;}
    public void setUserId(Long userId) {this.userId = userId;}

    public Long getQuizId() {return quizId;}
    public void setQuizId(Long quizId) {this.quizId = quizId;}

    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
}
