package com.backend.libros.services.impl;

import com.backend.libros.entities.Author;
import com.backend.libros.persistence.AuthorDAO;
import com.backend.libros.repositories.AuthorRepository;
import com.backend.libros.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDAO authorDAO;
    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorDAO.findById(id);
    }


    @Override
    public void save(Author author) {
        authorDAO.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorDAO.deleteById(id);
    }
}
