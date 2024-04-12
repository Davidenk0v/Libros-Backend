package com.backend.libros.persistence;

import com.backend.libros.entities.Author;
import com.backend.libros.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByEmail(String email);
    void save(UserEntity user);
    void deleteById(Long id);
}
