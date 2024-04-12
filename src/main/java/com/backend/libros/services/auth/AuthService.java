package com.backend.libros.services.auth;

import com.backend.libros.entities.UserEntity;
import com.backend.libros.payload.request.LoginDTO;
import com.backend.libros.payload.response.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface AuthService {
    public ResponseEntity<?> login(LoginDTO login) throws Exception ;

    public ResponseEntity<?> register(UserDTO user) throws Exception ;
}
