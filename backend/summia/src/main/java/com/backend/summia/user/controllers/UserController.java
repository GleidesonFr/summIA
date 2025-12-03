package com.backend.summia.user.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.summia.dto.UserDTO;
import com.backend.summia.user.models.User;
import com.backend.summia.user.services.UserService;

import java.net.http.HttpClient;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO user) {
        User responseUser = userService.createUser(user);
        
        return new ResponseEntity<>(responseUser, HttpStatus.CREATED);
    }
    
    @GetMapping("user/{id}")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        User responseUser = userService.getById(id);

        return new ResponseEntity<>(responseUser, HttpStatus.OK);
    }
    
    @PutMapping("user/{id}")
    public ResponseEntity<User> updateProfile(@PathVariable UUID id, @RequestBody UserDTO user) {
        User responUser = userService.updateProfile(id, user);

        return new ResponseEntity<>(responUser, HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable UUID id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Conta deletada com sucesso.", HttpStatus.OK);
    }
}
