package com.frasatodev.ticall.controllers;

import com.frasatodev.ticall.models.User;
import com.frasatodev.ticall.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/userid/{userid}")
    public User findUserById(@PathVariable UUID userId){
        return userService.findByUserId(userId);
    }

}
