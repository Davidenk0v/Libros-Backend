package com.backend.libros.repositories;

import com.backend.libros.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Author, Long> {
}
