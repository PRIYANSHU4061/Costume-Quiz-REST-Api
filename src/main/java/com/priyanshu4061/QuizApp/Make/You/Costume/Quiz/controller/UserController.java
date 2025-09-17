package com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.controller;

import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.apiResponce.ApiResponse;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.entity.User;
import com.priyanshu4061.QuizApp.Make.You.Costume.Quiz.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId){
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
}
