package com.backend.libros.controllers;

import com.backend.libros.payload.response.BookDTO;
import com.backend.libros.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public ResponseEntity<?> getAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO){
        return bookService.save(bookDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        return bookService.deleteById(id);
    }

}
