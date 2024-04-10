package com.backend.libros.entities.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
public class CategoryDTO {

        private Long id;
        private String name;
        private Set<BookDTO> books;
    }
