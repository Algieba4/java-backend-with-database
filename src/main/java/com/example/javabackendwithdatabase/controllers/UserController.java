package com.example.javabackendwithdatabase.controllers;

import com.example.javabackendwithdatabase.models.dto.UserDTO;
import com.example.javabackendwithdatabase.models.entities.User;
import com.example.javabackendwithdatabase.repository.UserRepository;
import com.example.javabackendwithdatabase.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Integer> createUser(@RequestBody UserDTO userDTO) {
        UserDTO returnUser = userService.saveUser(userDTO);
        return ResponseEntity.created(URI.create(returnUser.getId().toString())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        Boolean response = userService.deleteUser(id);
        if(response) {
            return ResponseEntity.ok("successfully deleted user");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("failed to delete user");
    }

    @GetMapping("/")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO, @PathVariable Integer id) {
        userDTO.setId(id);
        userService.saveUser(userDTO);
        return ResponseEntity.ok("successfully updated user");
    }

}
