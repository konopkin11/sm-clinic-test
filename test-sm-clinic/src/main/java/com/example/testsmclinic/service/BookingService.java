package com.example.testsmclinic.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsmclinic.model.Booking;
import com.example.testsmclinic.model.Room;
import com.example.testsmclinic.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public List<Room> findRooms(Integer minimalSeats, LocalDateTime startFreeDateTime, LocalDateTime endFreeDateTime) {
        return bookingRepository.findRoomsByRoomIdAndTimeRangeAndSeats(startFreeDateTime, endFreeDateTime, minimalSeats);
    }

    public Booking bookRoom(Long roomId, LocalDateTime startTime, LocalDateTime endTime) {
        // Проверка на шаг в 30 минут
        long minutesBetween = ChronoUnit.MINUTES.between(startTime, endTime);
        if (minutesBetween % 30 != 0) {
            throw new IllegalArgumentException("Промежуток бронирования должен быть кратным 30 минутам");
        }
        if (startTime.getMinute() % 30 != 0 || endTime.getMinute() % 30 != 0 || startTime.equals(endTime)) {
            throw new IllegalArgumentException("Промежуток бронирования должен быть кратным 30 минутам");
        }

        // Проверка на полное бронирование комнаты
        List<Booking> existingBookings = bookingRepository.findBookingsByRoomIdAndTimeRange(roomId, startTime, endTime);
        if (!existingBookings.isEmpty()) {
            throw new IllegalArgumentException("Комната уже забронирована на указанный промежуток времени");
        }


        Booking newBooking = Booking.builder()
                .startTime(startTime)
                .endTime(endTime)
                .room(Room.builder().id(roomId).build())
                .build();
        bookingRepository.save(newBooking);


        return newBooking;

    }

}
