package com.backend.libros.services;

import com.backend.libros.entities.UserEntity;
import com.backend.libros.payload.response.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    ResponseEntity<?> findAll();
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> save(UserDTO user);
    ResponseEntity<?> deleteById(Long id);
}
