package com.backend.libros.services.impl;

import com.backend.libros.config.Mapper;
import com.backend.libros.entities.Category;
import com.backend.libros.payload.response.CategoryDTO;
import com.backend.libros.persistence.CategoryDAO;
import com.backend.libros.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.backend.libros.config.Mapper.categoryToDTO;
import static com.backend.libros.config.Mapper.dtoToCategory;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public ResponseEntity<?> findAll() {
        List<Category> categories = categoryDAO.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>("No se encontraron categorias", HttpStatus.NOT_FOUND);
        }
        categories.stream()
                .map(Mapper::categoryToDTO)
                .toList();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<Category> optionalCategory = categoryDAO.findById(id);

        if(optionalCategory.isPresent()){
            CategoryDTO categoryDTO = categoryToDTO(optionalCategory.get());
            return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>("No se encontro ninguna categoría con ese ID", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> save(CategoryDTO category) {
        try{
            categoryDAO.save(dtoToCategory(category));
            return new ResponseEntity<>("Categoria guardada correctamente", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al crear categoría", HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        Optional<Category> optionalCategory = categoryDAO.findById(id);
        if(optionalCategory.isPresent()){
            categoryDAO.deleteById(id);
            return new ResponseEntity<>("Categoría borrada correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("La categoría con ID " + id + " no existe.", HttpStatus.NOT_FOUND);

    }
}
