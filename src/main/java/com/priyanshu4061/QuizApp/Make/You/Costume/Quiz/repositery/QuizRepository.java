package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    boolean existsByTitle(String title);
}
