package com.backend.libros.config;

import com.backend.libros.payload.request.UserValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ValidationsConfig {

    @Bean
    public UserValidation userValidation() {
        return new UserValidation();
    }
}