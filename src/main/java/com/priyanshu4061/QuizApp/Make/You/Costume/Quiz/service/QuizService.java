package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.service;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.apiResponce.ApiResponse;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Quiz;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception.QuizAlreadyExistException;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception.QuizNotFoundException;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery.QuizRepository;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;
@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public ApiResponse addQuiz(Quiz quiz)  {

        if(quizRepository.existsByTitle(quiz.getTitle())){
            throw new QuizAlreadyExistException("Quiz Already Exist By this Title! Please change the title");
        }
        quizRepository.save(quiz);
        return new ApiResponse("Quiz added Successfully");
    }

    public List<Quiz> getAllQuiz(){
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long quizId){
        return quizRepository.findById(quizId).orElseThrow(() -> new QuizNotFoundException("Quiz doesn't existed by id : " + quizId));
    }

    public ApiResponse deleteQuiz(Long quizId){
        if(quizRepository.existsById(quizId)){
            quizRepository.deleteById(quizId);
            return new ApiResponse("Quiz deleted Successfully");
        }else {
            throw new QuizNotFoundException("Quiz not found by this id : " + quizId);
        }
    }
}
