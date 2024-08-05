package com.example.parcial.demo.services;

import com.example.parcial.demo.models.HistoriaClinica;
import com.example.parcial.demo.models.Mascota;
import com.example.parcial.demo.repositories.HistoriaClinicaRepository;
import com.example.parcial.demo.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaService {
    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<HistoriaClinica> findAll() {
        return historiaClinicaRepository.findAll();
    }

    public HistoriaClinica findById(Long id) {
        return historiaClinicaRepository.findById(id).orElse(null);
    }

    public HistoriaClinica save(HistoriaClinica historiaClinica, Long mascotaId) {
        Mascota mascota = mascotaRepository.findById(mascotaId).orElse(null);
        if (mascota == null) {
            return null;
        }
        historiaClinica.setMascota(mascota);
        return historiaClinicaRepository.save(historiaClinica);
    }

    public void deleteById(Long id) {
        historiaClinicaRepository.deleteById(id);
    }

    public List<HistoriaClinica> findByMascotaId(Long mascotaId) {
        return historiaClinicaRepository.findByMascotaId(mascotaId);
    }
}
