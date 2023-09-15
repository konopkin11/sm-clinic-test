package com.example.testsmclinic.DTO;

import com.example.testsmclinic.model.Coworking;
import com.example.testsmclinic.model.Room;

import lombok.Data;

@Data
public class CoworkingDto {
    String address;

    public Coworking CoworkingDtoToCoworking() {
        return CoworkingDtoToCoworking(null);
    }

    public Coworking CoworkingDtoToCoworking(Long id) {
        return Coworking.builder()
                .address(this.address)
                .id(id)
                .build();
    }
}
