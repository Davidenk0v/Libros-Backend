package com.backend.libros.services;

import com.backend.libros.entities.Author;
import com.backend.libros.payload.response.AuthorDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    ResponseEntity<?> findAll();
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> save(AuthorDTO author);
    ResponseEntity<?> deleteById(Long id);
}
