package com.frasatodev.ticall.controllers;

import com.frasatodev.ticall.models.User;
import com.frasatodev.ticall.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String username, @RequestBody String password){
        Optional<User> userOptional = userService.validateUser(username, password);

        if(userOptional.isPresent()){
            User user = userOptional.get();
            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.status(404).body("User not found!");
        }
    }

}
