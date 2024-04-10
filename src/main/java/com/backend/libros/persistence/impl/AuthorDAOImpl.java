package com.backend.libros.persistence.impl;

import com.backend.libros.entities.Author;
import com.backend.libros.persistence.AuthorDAO;
import com.backend.libros.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AuthorDAOImpl implements AuthorDAO {
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }


    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
