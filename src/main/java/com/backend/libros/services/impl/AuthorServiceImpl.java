package com.backend.libros.services.impl;

import com.backend.libros.config.Mapper;
import com.backend.libros.entities.Author;
import com.backend.libros.payload.response.AuthorDTO;
import com.backend.libros.persistence.AuthorDAO;
import com.backend.libros.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.backend.libros.config.Mapper.*;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDAO authorDAO;
    @Override
    public ResponseEntity<?> findAll() {
        List<Author> authors = authorDAO.findAll();
        if(authors.isEmpty()){
            return new ResponseEntity<>("No se encontraron autores", HttpStatus.NOT_FOUND);
        }
        authors.stream()
                .map(Mapper::authorToDTO)
                .toList();

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> findById(Long id) {

        Optional<Author> optionalAuthor = authorDAO.findById(id);

        if(optionalAuthor.isPresent()){
            AuthorDTO authorDTO = authorToDTO(optionalAuthor.get());
            return new ResponseEntity<>(authorDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>("No se encontro ningún autor con ese ID", HttpStatus.NOT_FOUND);

    }
    @Override
    public ResponseEntity<?> save(AuthorDTO author){
        try{
            authorDAO.save(dtoToAuthor(author));
            return new ResponseEntity<>("Autor añadido correctamente", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al añadir el autor", HttpStatus.BAD_REQUEST);
        }
    }
    @Override
    public ResponseEntity<?> deleteById(Long id) {
        Optional<Author> optionalAuthor = authorDAO.findById(id);
        if(optionalAuthor.isPresent()){
            authorDAO.deleteById(id);
            return new ResponseEntity<>("Autor borrado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("El autor con ID " + id + " no existe.", HttpStatus.NOT_FOUND);
    }
}
