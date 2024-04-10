package com.backend.libros.entities.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
public class BookDTO {

    private Long id;
    private String title;
    private AuthorDTO author;
    private CategoryDTO category;
}
