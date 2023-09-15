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

import com.example.testsmclinic.DTO.RoomDto;
import com.example.testsmclinic.model.Room;
import com.example.testsmclinic.service.RoomService;

@RestController
@RequestMapping("rooms")
public class RoomController {
    @Autowired
    RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody RoomDto room) {
        if (room.getCoworkingId() == null || room.getNumberOfSeats() < 1 || room.getNumberOfSeats() > 20) {
            return ResponseEntity.badRequest().build();
        }
        Room createdRoom = roomService.createRoom(room.RoomDtoToRoom());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdRoom.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomService.findRoomById(id);
        return ResponseEntity.ok(room);
    }

    @PutMapping("{id}")
    public ResponseEntity updateRoom(@PathVariable Long id, @RequestBody RoomDto room) {
        if (room.getCoworkingId() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (!roomService.updateRoom(room.RoomDtoToRoom(id))) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteRoom(@PathVariable Long id) {
        if (!roomService.deleteRoom(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }
}
