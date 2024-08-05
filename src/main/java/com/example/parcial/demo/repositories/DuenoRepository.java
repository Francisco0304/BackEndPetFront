package com.example.parcial.demo.repositories;

import com.example.parcial.demo.models.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DuenoRepository extends JpaRepository<Dueno, Long> {
    Optional<Dueno> findByCedula(int cedula);
}
