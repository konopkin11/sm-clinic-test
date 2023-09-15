package com.example.testsmclinic.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.testsmclinic.model.Booking;
import com.example.testsmclinic.model.Room;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId")
    List<Booking> findBookingsByRoomId(Long roomId);


    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId " +
            "AND (:startTime < b.startTime OR :startTime < b.endTime) " +
            "AND (:endTime >= b.endTime OR :endTime >= b.startTime) ")
    List<Booking> findBookingsByRoomIdAndTimeRange(Long roomId, LocalDateTime startTime, LocalDateTime endTime);

    @Query("SELECT b.room FROM Booking b " +
            "WHERE :startTime <= b.startTime AND :endTime > b.endTime " +
            "AND b.room.numberOfSeats >= :minimalSeats ")
    List<Room> findRoomsByRoomIdAndTimeRangeAndSeats(LocalDateTime startTime, LocalDateTime endTime, Integer minimalSeats);
}
