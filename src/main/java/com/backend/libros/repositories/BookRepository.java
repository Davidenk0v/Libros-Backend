package com.backend.libros.repositories;

import com.backend.libros.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    Set<Book> findByCategory(Long idCategory);
}
