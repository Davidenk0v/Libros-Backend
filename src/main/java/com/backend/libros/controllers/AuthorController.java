package com.backend.libros.controllers;

import com.backend.libros.payload.response.AuthorDTO;
import com.backend.libros.services.AuthorService;
import com.backend.libros.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public ResponseEntity<?> getAllAuthors(){
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id){
        return authorService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> addAuthor(@RequestBody AuthorDTO authorDTO){
        return authorService.save(authorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id){
        return authorService.deleteById(id);
    }

}
