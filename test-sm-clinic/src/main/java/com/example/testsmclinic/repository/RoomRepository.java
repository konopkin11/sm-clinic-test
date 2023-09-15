package com.example.testsmclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testsmclinic.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
