package com.backend.libros.persistence;

import com.backend.libros.entities.Author;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<Author> findAll();
    Optional<Author> findById(Long id);
    void save(Author author);
    void deleteById(Long id);
}
