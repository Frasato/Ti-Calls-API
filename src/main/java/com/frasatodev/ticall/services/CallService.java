package com.frasatodev.ticall.services;

import com.frasatodev.ticall.models.Call;
import com.frasatodev.ticall.repositories.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CallService {

    @Autowired
    private CallRepository callRepository;

    public List<Call> getAllCalls(){
        return callRepository.findAll();
    }

    public void removeCall(Call call){
        callRepository.delete(call);
    }

    public Optional<Call> findCallById(UUID id){
        return callRepository.findById(id);
    }

}
