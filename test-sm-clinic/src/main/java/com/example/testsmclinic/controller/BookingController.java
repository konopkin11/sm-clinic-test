package com.example.testsmclinic.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsmclinic.DTO.BookingDto;
import com.example.testsmclinic.service.BookingService;

@RestController
@RequestMapping("bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> addBooking(@RequestBody BookingDto booking) {
        bookingService.bookRoom(booking.getRoomId(), booking.getStartTime(), booking.getEndTime());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getFreeRooms(
            @RequestParam(required = false, name = "minimalSeats") Integer minimalSeats,
            @RequestParam(required = true, name = "startTime") LocalDateTime startTime,
            @RequestParam(required = true, name = "endTime") LocalDateTime endTime
    ) {
        return ResponseEntity.ok(bookingService.findRooms(minimalSeats, startTime, endTime));
    }

}
