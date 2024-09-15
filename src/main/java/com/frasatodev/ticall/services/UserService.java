package com.frasatodev.ticall.services;

import com.frasatodev.ticall.models.User;
import com.frasatodev.ticall.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserId(UUID userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Can't find user by id: " + userId));
    }

}
