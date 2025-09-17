package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.controller;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.apiResponce.ApiResponse;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Option;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.service.OptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @PutMapping("/{optionId}")
    public ResponseEntity<ApiResponse> updateOption(
            @PathVariable Long optionId,
            @RequestBody Option option
    ) {
        return ResponseEntity.ok(optionService.updateOption(optionId, option));
    }

    @DeleteMapping("/{optionId}")
    public ResponseEntity<ApiResponse> deleteOption(@PathVariable Long optionId) {
        return ResponseEntity.ok(optionService.deleteOption(optionId));
    }


    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Option>> getOptionsByQuestion(@PathVariable Long questionId) {
        return ResponseEntity.ok(optionService.getOptionsByQuestionId(questionId));
    }

    @GetMapping("/{optionId}")
    public ResponseEntity<Option> getOptionById(@PathVariable Long optionId) {
        return ResponseEntity.ok(optionService.getOptionById(optionId));
    }
}

