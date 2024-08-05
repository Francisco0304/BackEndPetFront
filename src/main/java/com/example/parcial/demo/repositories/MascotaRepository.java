package com.example.parcial.demo.repositories;

import com.example.parcial.demo.models.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
