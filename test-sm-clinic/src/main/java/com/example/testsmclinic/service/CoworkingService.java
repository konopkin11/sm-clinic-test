package com.example.testsmclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsmclinic.model.Coworking;
import com.example.testsmclinic.repository.CoworkingRepository;

@Service
public class CoworkingService {

    @Autowired
    CoworkingRepository coworkingRepository;

    public Coworking createCoworking(Coworking coworking) {
        return coworkingRepository.save(coworking);
    }

    public Coworking findCoworkingById(Long id) {
        return coworkingRepository.findById(id).get();
    }

    public boolean updateCoworking(Coworking coworking) {
        if (!coworkingRepository.existsById(coworking.getId())) {
            return false;
        }
        coworkingRepository.save(coworking);
        return true;
    }

    public boolean deleteCoworking(Long id) {
        if (!coworkingRepository.existsById(id)) {
            return false;
        }
        coworkingRepository.deleteById(id);
        return true;
    }
}
