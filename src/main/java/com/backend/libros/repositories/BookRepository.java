package com.backend.libros.repositories;

import com.backend.libros.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
//    Set<Book> findByCategory(Long idCategory);
}
