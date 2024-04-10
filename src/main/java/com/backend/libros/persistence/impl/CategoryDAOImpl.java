package com.backend.libros.persistence.impl;

import com.backend.libros.entities.Book;
import com.backend.libros.entities.Category;
import com.backend.libros.persistence.CategoryDAO;
import com.backend.libros.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }


    @Override
    public void save(Category author) {
        categoryRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
