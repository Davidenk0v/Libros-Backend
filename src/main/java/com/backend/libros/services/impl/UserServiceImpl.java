package com.backend.libros.services.impl;

import com.backend.libros.config.Mapper;
import com.backend.libros.entities.Author;
import com.backend.libros.entities.UserEntity;
import com.backend.libros.payload.response.AuthorDTO;
import com.backend.libros.payload.response.UserDTO;
import com.backend.libros.persistence.UserDAO;
import com.backend.libros.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.backend.libros.config.Mapper.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;

    @Override
    public ResponseEntity<?> findAll(){
        List<UserEntity> users = userDao.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<>("No se encotraron usuarios", HttpStatus.NOT_FOUND);
        }
        users.stream()
                .map(Mapper::userToDTO)
                .toList();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findById(Long id){
        Optional<UserEntity> optionalUser = userDao.findById(id);

        if(optionalUser.isPresent()){
            UserDTO userDTO = userToDTO(optionalUser.get());
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>("No se encontro ningún usuario con ese ID", HttpStatus.NOT_FOUND);

    }
    @Override
    public ResponseEntity<?> save(UserDTO user){
            try{
                userDao.save(dtoToUser(user));
                return new ResponseEntity<>("Usuario añadido correctamente", HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>("Error al añadir el usuario", HttpStatus.BAD_REQUEST);
            }
        }
    @Override
    public ResponseEntity<?> deleteById(Long id){
        Optional<UserEntity> optionalUser = userDao.findById(id);
        if(optionalUser.isPresent()){
            userDao.deleteById(id);
            Map<String, String> response = new HashMap();
            response.put("OK","Usuario borrado correctamente" );
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>("El usuario con ID " + id + " no existe.", HttpStatus.NOT_FOUND);

    }
}
