package com.frasatodev.ticall.services;

import com.frasatodev.ticall.models.Call;
import com.frasatodev.ticall.models.User;
import com.frasatodev.ticall.repositories.CallRepository;
import com.frasatodev.ticall.repositories.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CallRepository callRepository;

    public Call saveCallForUser(Call call, UUID userId){
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isPresent()){
            User user = userOptional.get();
            call.setUser(user);
            return callRepository.save(call);
        }else{
            throw new RuntimeException("Error to find or save call!");
        }
    }

    public List<Call> getAllCallsForUser(UUID userId){
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isPresent()){
            User user = userOptional.get();
            return user.getCalls();
        }else{
            throw new RuntimeException("Error on find calls for user");
        }
    }

    public Optional<User> validateUser(String username, String password){
        return userRepository.findByUsernamePassword(username, password);
    }

}
