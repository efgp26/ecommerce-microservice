package com.microservice.user.controller;

import com.microservice.user.controller.dto.ApiResponses;
import com.microservice.user.controller.dto.UserDTO;
import com.microservice.user.entities.UserEntity;
import com.microservice.user.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/microservice/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/findUserId/{id}")

    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<UserEntity> optionalUser = userService.findById(id);

        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();

            UserDTO userDTO = UserDTO.builder()

                    .email(user.getEmail())
                    .name(user.getName())
                    .username(user.getUsername())
                    .lastName(user.getLastName())
                    .build();

            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario encontrado",  userDTO));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/save")
    public ResponseEntity<?> createUser( @RequestBody UserDTO createUserDTO) {

        UserEntity userEntity = UserEntity.builder()
                .name(createUserDTO.getName())
                .username(createUserDTO.getEmail())
                .lastName(createUserDTO.getLastName())
                .email(createUserDTO.getEmail())
                .password(createUserDTO.getPassword())
                .build();

        userService.save(userEntity);

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario guardado", createUserDTO ));
    }


    @GetMapping("/listAllUsers")
    public ResponseEntity<?> findAll(){
        List<UserDTO> userDTOList = userService.findAll()
                .stream()
                .map(user -> UserDTO.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .username(user.getUsername())
                        .lastName(user.getLastName())
                        .build())
                .toList();

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "", userDTOList ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<UserEntity> optionalUser = userService.findById(id);

        if (optionalUser.isPresent()){
            userService.deleteById(id);
            return ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario eliminado con éxito", null ));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "Usuario no encontrado", null));
    }
}
