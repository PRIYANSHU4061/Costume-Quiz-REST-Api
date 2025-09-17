package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.controller;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto.AnswerDto;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto.ResultDto;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.service.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/submit/{userId}/{quizId}")
    public ResponseEntity<ResultDto> submitQuiz(
            @PathVariable Long userId,
            @PathVariable Long quizId,
            @RequestBody List<AnswerDto> answers
    )
    {
        ResultDto resultDto = resultService.submitQuiz(userId, quizId, answers);
        return ResponseEntity.ok(resultDto);
    }

}

