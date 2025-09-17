package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    boolean existsByQuestionText(String questionText);
}
