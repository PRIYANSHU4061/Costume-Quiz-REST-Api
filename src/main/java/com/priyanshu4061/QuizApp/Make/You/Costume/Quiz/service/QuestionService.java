package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.service;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.apiResponce.ApiResponse;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Question;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Quiz;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception.QuestionAlreadyExistException;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception.QuestionNotFoundException;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery.QuestionRepository;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }


    public ApiResponse addQuestion(Long quizId, Question question) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new QuestionNotFoundException("Quiz not found with id: " + quizId));

        question.setQuiz(quiz);  // set the quiz before saving

        if (question.getOptions() == null) {
            question.setOptions(new ArrayList<>());
        }

        if (questionRepository.existsByQuestionText(question.getQuestionText())) {
            throw new QuestionAlreadyExistException("Question already exists! Please change the Question");
        }

        question.getOptions().forEach(option -> option.setQuestion(question));

        questionRepository.save(question);
        return new ApiResponse("Question added successfully");
    }

    public ApiResponse updateQuestion(Long questionId, Question newData) {
        return questionRepository.findById(questionId).map(question -> {
            question.setQuestionText(newData.getQuestionText());

            if (question.getOptions() == null) {
                question.setOptions(new ArrayList<>());
            } else {
                question.getOptions().clear();
            }

            if (newData.getOptions() != null) {
                newData.getOptions().forEach(option -> {
                    option.setQuestion(question);
                    question.getOptions().add(option);
                });
            }

            questionRepository.save(question);
            return new ApiResponse("Question updated successfully");
        }).orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + questionId));
    }

    public ApiResponse deleteQuestion(Long questionId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found with id: " + questionId));

        questionRepository.delete(question);
        return new ApiResponse("Question deleted successfully");
    }
}
