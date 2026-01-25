package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PrototypeConfig {

    @Bean
    @Scope("prototype")
    public Prototype prototype(){
        return new Prototype();
    }
}
