package com.frasatodev.ticall.controllers;

import com.frasatodev.ticall.dtos.CallDto;
import com.frasatodev.ticall.dtos.UserDto;
import com.frasatodev.ticall.models.Call;
import com.frasatodev.ticall.models.User;
import com.frasatodev.ticall.services.CallService;
import com.frasatodev.ticall.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CallService callService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto){
        if(userDto.getUsername().isEmpty() || userDto.getPassword().isEmpty()){
            return ResponseEntity.status(400).body("Cannot register users with empty fields");
        }else{
            User user = new User();

            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setRole("USER");

            return ResponseEntity.status(200).body(userService.registerUser(user));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        Optional<User> userOptional = userService.validateUser(userDto.getUsername(), userDto.getPassword());

        if(userOptional.isPresent()){
            User user = userOptional.get();
            return ResponseEntity.status(200).body(user);
        }else {
            return ResponseEntity.status(404).body("User not found!");
        }
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createCall(@PathVariable UUID userId, @RequestBody CallDto callDto){
        try{

            Call call = new Call();
            call.setTitle(callDto.getTitle());
            call.setDescription(callDto.getDescription());
            call.setSector(callDto.getSector());
            call.setWhoCalled(callDto.getWhoCalled());

            Call createdCall = userService.saveCallForUser(call, userId);
            return ResponseEntity.ok(createdCall);
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error creating call: " + e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCallsByUser(@PathVariable UUID userId){
        try{
            List<Call> userCalls = userService.getAllCallsForUser(userId);
            return ResponseEntity.ok(userCalls);
        }catch (Exception e){
            return ResponseEntity.status(404).body("Calls not found for user: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Call>> getAllCalls(){
        List<Call> calls = callService.getAllCalls();
        return ResponseEntity.status(200).body(calls);
    }

}
