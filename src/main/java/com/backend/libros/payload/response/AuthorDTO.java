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
public class AuthorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Book> books;
}
