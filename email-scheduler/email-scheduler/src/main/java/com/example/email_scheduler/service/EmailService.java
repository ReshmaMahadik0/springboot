package com.example.email_scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String userName){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Registration successful");
        message.setText(
                "Hello " + userName + ",\n\n" +
                        "You have successfully registered.\n"+
                        "Welcome to our platform."
        );
        javaMailSender.send(message);
    }
}
