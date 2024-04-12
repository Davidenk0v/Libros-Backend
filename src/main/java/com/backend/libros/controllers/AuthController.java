package com.backend.libros.controllers;

import java.util.HashMap;

import com.backend.libros.entities.UserEntity;
import com.backend.libros.payload.request.LoginDTO;
import com.backend.libros.payload.request.ResponseDTO;
import com.backend.libros.payload.response.UserDTO;
import com.backend.libros.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    private ResponseEntity<?> register(@RequestBody UserDTO user) throws Exception{
        return authService.register(user);
    }


    @PostMapping("/login")
    private ResponseEntity<?> login (@RequestBody LoginDTO request) throws Exception{
        return authService.login(request);
    }

}