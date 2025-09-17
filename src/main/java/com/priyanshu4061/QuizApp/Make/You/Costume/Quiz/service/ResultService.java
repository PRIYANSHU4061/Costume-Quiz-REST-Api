package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.service;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto.AnswerDto;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.dto.ResultDto;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.*;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.mapper.ResultMapper;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;
    private final UserRepository userRepository;
    private final OptionRepository optionRepository;
    private final QuizRepository quizRepository;

    public ResultService(ResultRepository resultRepository,
                         UserRepository userRepository,
                         OptionRepository optionRepository,
                         QuizRepository quizRepository) {
        this.resultRepository = resultRepository;
        this.userRepository = userRepository;
        this.optionRepository = optionRepository;
        this.quizRepository = quizRepository;
    }

    public ResultDto submitQuiz(Long userId, Long quizId, List<AnswerDto> answers) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new IllegalArgumentException("Quiz not found with id: " + quizId));

        int score = 0;

        for (AnswerDto answer : answers) {
            Option correctOption = optionRepository.findByQuestion_QuestionIdAndCorrectTrue(answer.getQuestionId())
                    .orElseThrow(() -> new IllegalArgumentException("Correct option not found for question: " + answer.getQuestionId()));

            if (correctOption.getOptionId().equals(answer.getSelectedOptionId())) {
                score++;
            }
        }

        Result result = new Result();
        result.setUser(user);
        result.setQuiz(quiz);
        result.setScore(score);
        result.setLocalDateTime(LocalDateTime.now());

        return ResultMapper.toDto(resultRepository.save(result));
    }
}
