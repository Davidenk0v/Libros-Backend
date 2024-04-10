package com.backend.libros.entities.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
public class AuthorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<BookDTO> books;
}
