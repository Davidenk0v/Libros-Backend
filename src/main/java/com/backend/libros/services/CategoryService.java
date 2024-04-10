package com.backend.libros.services;

import com.backend.libros.entities.Category;
import com.backend.libros.payload.response.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    ResponseEntity<?> findAll();
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> save(CategoryDTO category);
    ResponseEntity<?> deleteById(Long id);
}
