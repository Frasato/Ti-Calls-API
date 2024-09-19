package com.frasatodev.ticall.services;

import com.frasatodev.ticall.models.EndCall;
import com.frasatodev.ticall.repositories.EndCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndCallService {

    @Autowired
    private EndCallRepository endCallRepository;

    public EndCall saveCall(EndCall endCall){
        return endCallRepository.save(endCall);
    }

}
