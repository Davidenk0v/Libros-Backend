package com.backend.libros.payload.response;

import com.backend.libros.entities.Book;
import lombok.*;

import java.util.List;
import java.util.Set;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDTO {

        private Long id;
        private String name;
        private List<Book> books;
    }
