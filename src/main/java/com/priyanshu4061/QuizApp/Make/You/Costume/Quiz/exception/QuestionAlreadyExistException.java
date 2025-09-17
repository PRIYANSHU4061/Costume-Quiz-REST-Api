package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class QuestionAlreadyExistException extends RuntimeException{
    public QuestionAlreadyExistException(String message) {
        super(message);
    }
}
