package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.service;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.apiResponce.ApiResponse;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.User;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception.UserAlreadyExistException;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.exception.UserNotFoundException;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.repositery.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse addUser(User user){
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new UserAlreadyExistException("User Already Existed By this Username! Please choose another Username");
        }
        userRepository.save(user);
        return new ApiResponse("User added Successfully");
    }

    public ApiResponse deleteUser(Long userId){
        if (!userRepository.existsById(userId)) {
            return new ApiResponse("User not found");
        }
        userRepository.deleteById(userId);
        return new ApiResponse("User deleted successfully");
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
