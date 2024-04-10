package com.backend.libros.persistence;

import com.backend.libros.entities.Category;

import java.util.List;
import java.util.Optional;


public interface CategoryDAO {

    List<Category> findAll();
    Optional<Category> findById(Long id);
    void save(Category author);
    void deleteById(Long id);
}
