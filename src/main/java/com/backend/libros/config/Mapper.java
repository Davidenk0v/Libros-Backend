package com.backend.libros.config;

import com.backend.libros.entities.Author;
import com.backend.libros.entities.Book;
import com.backend.libros.entities.Category;
import com.backend.libros.entities.UserEntity;
import com.backend.libros.payload.response.AuthorDTO;
import com.backend.libros.payload.response.BookDTO;
import com.backend.libros.payload.response.CategoryDTO;
import com.backend.libros.payload.response.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class Mapper {

    //AUTHORS
    public static AuthorDTO authorToDTO(Author author){
        return new AuthorDTO()
                .builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .books(author.getBooks())
                .build();
    }

    public static Author dtoToAuthor(AuthorDTO author){
        return new Author()
                .builder()
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .books(author.getBooks())
                .build();
    }

    //BOOKS
    public static BookDTO bookToDTO(Book book){
        return new BookDTO()
                .builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .category(book.getCategory())
                .build();
    }

    public static Book dtoToBook(BookDTO book){
        return new Book()
                .builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .category(book.getCategory())
                .build();
    }

    //CATEGORIES
    public static CategoryDTO categoryToDTO(Category category){
        return new CategoryDTO()
                .builder()
                .id(category.getId())
                .name(category.getName())
                .books(category.getBooks())
                .build();
    }

    public static Category dtoToCategory(CategoryDTO category){
        return new Category()
                .builder()
                .name(category.getName())
                .books(category.getBooks())
                .build();
    }

    //USERS
    public static UserDTO userToDTO(UserEntity user){
        return new UserDTO()
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static UserEntity dtoToUser(UserDTO userDTO){
        return new UserEntity()
                .builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }
}
