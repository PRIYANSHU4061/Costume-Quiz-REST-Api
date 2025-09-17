package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<Object> findByUsername(String username);
}
