package com.backend.libros.persistence.impl;

import com.backend.libros.entities.Author;
import com.backend.libros.entities.UserEntity;
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
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
