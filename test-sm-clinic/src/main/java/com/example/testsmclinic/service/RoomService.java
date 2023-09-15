package com.example.testsmclinic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.example.testsmclinic.model.Room;
import com.example.testsmclinic.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room findRoomById(Long id) {
        return roomRepository.findById(id).get();
    }

    public boolean updateRoom(Room room) {
        if (!roomRepository.existsById(room.getId())) {
            return false;
        }
        roomRepository.save(room);
        return true;
    }

    public boolean deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            return false;
        }
        roomRepository.deleteById(id);
        return true;
    }
}
