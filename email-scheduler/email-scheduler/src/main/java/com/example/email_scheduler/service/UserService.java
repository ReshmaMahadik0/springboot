package com.example.email_scheduler.service;

import com.example.email_scheduler.entity.User;
import com.example.email_scheduler.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public User registerUser(User user){

        if (userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already registered");
        }

        User savedUser = userRepository.save(user);

        emailService.sendEmail(
                savedUser.getEmail(),
                savedUser.getUserName()
        );
        return savedUser;
    }
}
