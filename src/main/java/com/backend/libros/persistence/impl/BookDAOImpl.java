package com.backend.libros.persistence.impl;

import com.backend.libros.entities.Author;
import com.backend.libros.entities.Book;
import com.backend.libros.persistence.BookDAO;
import com.backend.libros.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookDAOImpl implements BookDAO {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }


    @Override
    public void save(Book author) {
        bookRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
