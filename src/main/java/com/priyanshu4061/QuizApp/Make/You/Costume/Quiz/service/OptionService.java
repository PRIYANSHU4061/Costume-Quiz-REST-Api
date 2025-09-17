package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.service;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.apiResponce.ApiResponse;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Option;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Question;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception.OptionNotFoundException;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception.QuestionNotFoundException;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery.OptionRepository;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionService {

    private final OptionRepository optionRepository;
    private final QuestionRepository questionRepository;

    public OptionService(OptionRepository optionRepository, QuestionRepository questionRepository) {
        this.optionRepository = optionRepository;
        this.questionRepository = questionRepository;
    }


    public ApiResponse addOption(Long questionId, Option option) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + questionId));
        if (question.getOptions() == null) {
            question.setOptions(new ArrayList<>());
        }
        option.setQuestion(question);
        optionRepository.save(option);
        return new ApiResponse("Option added successfully");
    }


    public ApiResponse updateOption(Long optionId, Option newOptionData) {
        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new OptionNotFoundException("Option not found with id: " + optionId));
        option.setOptionText(newOptionData.getOptionText());
        option.setCorrect(newOptionData.isCorrect());
        optionRepository.save(option);
        return new ApiResponse("Option updated successfully");
    }


    public ApiResponse deleteOption(Long optionId) {
        if (!optionRepository.existsById(optionId)) {
            throw new OptionNotFoundException("Option not found with id: " + optionId);
        }
        optionRepository.deleteById(optionId);
        return new ApiResponse("Option deleted successfully");
    }


    public List<Option> getOptionsByQuestionId(Long questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + questionId));
        return optionRepository.findAll().stream()
                .filter(option -> option.getQuestion().getQuestionId().equals(questionId))
                .toList();
    }


    public Option getOptionById(Long optionId) {
        return optionRepository.findById(optionId)
                .orElseThrow(() -> new OptionNotFoundException("Option not found with id: " + optionId));
    }


}
