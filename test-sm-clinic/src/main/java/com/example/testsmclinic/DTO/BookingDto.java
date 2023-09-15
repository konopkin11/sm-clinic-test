package com.example.testsmclinic.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookingDto {
    LocalDateTime startTime;
    LocalDateTime endTime;
    Long roomId;
}
