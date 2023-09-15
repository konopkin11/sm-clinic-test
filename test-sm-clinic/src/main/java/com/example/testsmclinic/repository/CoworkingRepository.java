package com.example.testsmclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testsmclinic.model.Coworking;
@Repository
public interface CoworkingRepository  extends JpaRepository<Coworking, Long> {
}
