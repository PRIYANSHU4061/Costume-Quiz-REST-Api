package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery;


import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OptionRepository extends JpaRepository<Option, Long> {
    Optional<Option> findByQuestion_QuestionIdAndCorrectTrue(Long questionId);
}
