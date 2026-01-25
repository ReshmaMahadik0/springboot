package com.deploy.war.demoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/users")
    public List getUsers(){
        return List.of(
                "Siddhi",
                "Snehal",
                "Ketaki"
        );
    }
}
