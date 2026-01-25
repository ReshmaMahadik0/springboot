package com.example.hibernate_validation.controller;

import com.example.hibernate_validation.entity.User;
import com.example.hibernate_validation.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User user1 = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
}
