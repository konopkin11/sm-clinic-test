package com.example.testsmclinic.controller;


import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.testsmclinic.DTO.CoworkingDto;
import com.example.testsmclinic.model.Coworking;
import com.example.testsmclinic.service.CoworkingService;

@RestController
@RequestMapping("coworkings")
public class CoworkingController {
    @Autowired
    CoworkingService coworkingService;

    @PostMapping
    public ResponseEntity<Coworking> createCoworking(@RequestBody CoworkingDto coworking) {
        Coworking createdCoworking = coworkingService.createCoworking(coworking.CoworkingDtoToCoworking());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCoworking.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Coworking> getCoworkingById(@PathVariable Long id) {
        Coworking coworking = coworkingService.findCoworkingById(id);
        return ResponseEntity.ok(coworking);
    }

    @PutMapping("{id}")
    public ResponseEntity updateCoworking(@PathVariable Long id, @RequestBody CoworkingDto coworking) {
        if (!coworkingService.updateCoworking(coworking.CoworkingDtoToCoworking(id))) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteCoworking(@PathVariable Long id) {
        if (!coworkingService.deleteCoworking(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }
}

