package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.controller;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.apiResponce.ApiResponse;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto.QuestionDto;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Question;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.mapper.QuestionMapper;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private  final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add/{quizId}")
    public ResponseEntity<ApiResponse> addQuestion(
            @PathVariable Long quizId,
            @RequestBody QuestionDto questionDto) {

        Question question = QuestionMapper.toEntity(questionDto);
        return ResponseEntity.ok(questionService.addQuestion(quizId, question));
    }

    @GetMapping
    public List<QuestionDto> getAllQuestion(){
        return questionService.getAllQuestions().stream().map(QuestionMapper :: toDto).collect(Collectors.toList());
    }

    @PutMapping ("/{questionId}")
    public ResponseEntity<ApiResponse> updateQuestion(@PathVariable Long questionId, @RequestBody QuestionDto questionDto){
        return ResponseEntity.ok(questionService.updateQuestion(questionId, QuestionMapper.toEntity(questionDto)));
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<ApiResponse> deleteQuestion(@PathVariable Long questionId){
        return ResponseEntity.ok(questionService.deleteQuestion(questionId));
    }


}
