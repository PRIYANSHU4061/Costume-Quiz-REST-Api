package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.CONFLICT)
public class QuizAlreadyExistException extends RuntimeException {
    public QuizAlreadyExistException(String message) {
        super(message);
    }
}
