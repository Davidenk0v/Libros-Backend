package com.backend.libros.services.impl;

import com.backend.libros.config.Mapper;
import com.backend.libros.entities.Book;
import com.backend.libros.payload.response.BookDTO;
import com.backend.libros.persistence.BookDAO;
import com.backend.libros.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.backend.libros.config.Mapper.*;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;
    @Override
    public ResponseEntity<?> findAll() {
        List<Book> books = bookDAO.findAll();
        if (books.isEmpty()) {
            return new ResponseEntity<>("No se encontraron libros", HttpStatus.NOT_FOUND);
        }
        books.stream()
                .map(Mapper::bookToDTO)
                .toList();

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<Book> optionalBook = bookDAO.findById(id);

        if(optionalBook.isPresent()){
            BookDTO bookDTO = bookToDTO(optionalBook.get());
            return new ResponseEntity<>(bookDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>("No se encontro ningún libro con ese ID", HttpStatus.NOT_FOUND);

    }

    @Override
    public ResponseEntity<?> save(BookDTO book) {
        try{
            bookDAO.save(dtoToBook(book));
            return new ResponseEntity<>("Libro guardada correctamente", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al añadir el libro", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        Optional<Book> optionalBook = bookDAO.findById(id);
        if(optionalBook.isPresent()){
            bookDAO.deleteById(id);
            return new ResponseEntity<>("Libro borrado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("El libro con ID " + id + " no existe.", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> update(Long id, BookDTO bookDTO) {
        Optional<Book> bookOptional = bookDAO.findById(id);
        if(bookOptional.isPresent()){
            Book book = bookOptional.get()
                    .builder()
                    .title(bookDTO.getTitle())
                    .author(bookDTO.getAuthor())
                    .category(bookDTO.getCategory())
                    .build();

            bookDAO.save(book);
            return new ResponseEntity<>("Actualizado correctamente", HttpStatus.OK);
        }

        return new ResponseEntity<>("Error al actualizar", HttpStatus.BAD_REQUEST);
    }
}
