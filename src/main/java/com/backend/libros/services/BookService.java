package com.backend.libros.services;

import com.backend.libros.entities.Book;
import com.backend.libros.payload.response.BookDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    ResponseEntity<?> findAll();
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> save(BookDTO book);
    ResponseEntity<?> deleteById(Long id);
}
