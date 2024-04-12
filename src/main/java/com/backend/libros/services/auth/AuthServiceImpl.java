package com.backend.libros.services.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.backend.libros.entities.UserEntity;
import com.backend.libros.payload.request.LoginDTO;
import com.backend.libros.payload.request.ResponseDTO;
import com.backend.libros.payload.request.UserValidation;
import com.backend.libros.payload.response.UserDTO;
import com.backend.libros.persistence.UserDAO;
import com.backend.libros.repositories.UserRepository;
import com.backend.libros.services.jwt.JWTUtilityService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.backend.libros.config.Mapper.dtoToUser;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private JWTUtilityService jwtUtilityService;

    @Autowired
    private UserValidation userValidation;

    @Override
    public ResponseEntity<?> login(LoginDTO login) throws Exception {

            Optional<UserEntity> userOptional = userDAO.findByEmail(login.getEmail());
            //Primero comprobamos si el user existe en la base de datos
            if(userOptional.isEmpty()) {

                return new ResponseEntity<>("Usuario no registrado", HttpStatus.NOT_FOUND);
            }

            //Si existe comprobamos si la contraseña introducida es correcta
            if(verifyPassword(login.getPassword(), userOptional.get().getPassword())) {
                String jwt = jwtUtilityService.generateToken(userOptional.get().getId());
                Map<String, String> token = new HashMap<>();
                token.put("token", jwt);
                return new ResponseEntity<>(token, HttpStatus.OK);

            }
               return new ResponseEntity<>("Contraseña incorrecta", HttpStatus.UNAUTHORIZED);


    }

    @Override
    public ResponseEntity<?> register(UserDTO userDTO) throws Exception {

            ResponseDTO response = userValidation.validate(userDTO);

            if(response.getNumOfErrors() > 0) {
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }

            List<UserEntity> allUsers = userDAO.findAll();

            for(UserEntity repetUser : allUsers) {
                if(repetUser.getUsername() == userDTO.getUsername()) {
                    return new ResponseEntity<>("Ya existe un usuario con ese Username", HttpStatus.BAD_REQUEST);
                }

                if(userDAO.findByEmail(userDTO.getEmail()).isPresent()){
                    return new ResponseEntity<>("Ya existe un usuario con ese email", HttpStatus.BAD_REQUEST);
                }
            }
        UserEntity user = dtoToUser(userDTO);
        try {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            user.setPassword(encoder.encode(user.getPassword()));

            userDAO.save(user);
            Optional<UserEntity> userOptional = userDAO.findByEmail(user.getEmail());
            String jwt = jwtUtilityService.generateToken(userOptional.get().getId());
            Map<String, String> token = new HashMap<>();
            token.put("token", jwt);

            return new ResponseEntity<>(token, HttpStatus.CREATED);

        }catch(Exception e) {
            throw new Exception(e.toString());
        }
    }

    //Metodo para verificar si las contraseñas son iguales
    private boolean verifyPassword(String enteredPassword, String storedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, storedPassword);
    }
}