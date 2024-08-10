package com.api_rest.crud.crud.controller;

import java.util.List;

import com.api_rest.crud.crud.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api_rest.crud.crud.model.dto.UserDTO;
import com.api_rest.crud.crud.service.IUserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .lastName(user.getLastName())
                        .build())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> userList = userService.allUsers()
                .stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .lastName(user.getLastName())
                        .build())
                .toList();
        return ResponseEntity.ok(userList);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO){
        User user = User.builder()
                .name(userDTO.getName())
                .lastName(userDTO.getLastName())
                .build();

        User savedUser = userService.save(user);

        UserDTO savedUserDTO = UserDTO.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .lastName(savedUser.getLastName())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id){
        return userService.findById(id)
                .map(newuser ->{
                  newuser.setName(userDTO.getName());
                  newuser.setLastName(userDTO.getLastName());
                  User saveUser = userService.save(newuser);

                  UserDTO updateUser = UserDTO.builder()
                          .id(saveUser.getId())
                          .name(saveUser.getName())
                          .lastName(saveUser.getLastName())
                          .build();
                  return ResponseEntity.ok(updateUser);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> {
                    UserDTO userDTO = UserDTO.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .lastName(user.getLastName())
                            .build();

                    userService.delete(id);
                    return ResponseEntity.ok(userDTO);
                })
                .orElse(ResponseEntity.noContent().build());
    }



}//END CLASS
