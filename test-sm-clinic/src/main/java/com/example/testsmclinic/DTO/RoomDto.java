package com.example.testsmclinic.DTO;

import com.example.testsmclinic.model.Coworking;
import com.example.testsmclinic.model.Room;

import lombok.Data;

@Data
public class RoomDto {
    int numberOfSeats;
    Long coworkingId;

    public Room RoomDtoToRoom() {
        return RoomDtoToRoom(null);
    }

    public Room RoomDtoToRoom(Long id) {
        return Room.builder()
                .numberOfSeats(this.numberOfSeats)
                .id(id)
                .coworking(
                        this.coworkingId == null ? null :
                                Coworking.builder().id(this.coworkingId).build()
                ).build();
    }
}
