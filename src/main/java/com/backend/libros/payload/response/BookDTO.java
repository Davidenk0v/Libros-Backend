package com.backend.libros.payload.response;

import com.backend.libros.entities.Author;
import com.backend.libros.entities.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {

    private Long id;
    private String title;
    private Author author;
    private Category category;
}
