package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.controller;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.apiResponce.ApiResponse;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto.QuizDto;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.mapper.QuizMapper;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addQuiz(@RequestBody QuizDto quizDto)  {
        return ResponseEntity.ok(quizService.addQuiz(QuizMapper.toEntity(quizDto)));
    }
    @DeleteMapping("/{quizId}")
    public ResponseEntity<ApiResponse> deleteQuiz(@PathVariable Long quizId){
        return ResponseEntity.ok(quizService.deleteQuiz(quizId));
    }

    @GetMapping
    public List<QuizDto> getAllQuiz(){
        return quizService.getAllQuiz().stream().map(QuizMapper :: toDto).collect(Collectors.toList());
    }

    @GetMapping("/{quizId}")
    public QuizDto getQuizById(@PathVariable Long quizId){
        return QuizMapper.toDto(quizService.getQuizById(quizId));
    }
}
