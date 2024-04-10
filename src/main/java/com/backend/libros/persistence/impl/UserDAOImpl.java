package com.backend.libros.persistence.impl;

import com.backend.libros.entities.Author;
import com.backend.libros.persistence.AuthorDAO;
import com.backend.libros.persistence.UserDAO;
import com.backend.libros.repositories.AuthorRepository;
import com.backend.libros.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Author> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public void save(Author author) {
        userRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
