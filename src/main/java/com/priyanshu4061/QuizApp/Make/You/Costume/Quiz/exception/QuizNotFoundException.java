package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.http.HttpRequest;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class QuizNotFoundException extends RuntimeException{
    public QuizNotFoundException(String message) {
        super(message);
    }
}
