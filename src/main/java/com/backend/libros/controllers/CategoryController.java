package com.backend.libros.controllers;

import com.backend.libros.payload.response.CategoryDTO;
import com.backend.libros.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDTO bookDTO){
        return categoryService.save(bookDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        return categoryService.deleteById(id);
    }

}
