package com.example.testsmclinic.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @GeneratedValue
    @Id
    Long id;

    int numberOfSeats;

    @ManyToOne(cascade = CascadeType.MERGE)
    Coworking coworking;

}
