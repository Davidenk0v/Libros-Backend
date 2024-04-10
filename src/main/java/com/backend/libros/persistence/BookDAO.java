package com.backend.libros.persistence;

import com.backend.libros.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    public void save(Book author);
    public void deleteById(Long id);
}
