package com.example.parcial.demo.services;

import com.example.parcial.demo.models.Dueno;
import com.example.parcial.demo.models.Mascota;
import com.example.parcial.demo.repositories.DuenoRepository;
import com.example.parcial.demo.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private DuenoRepository duenoRepository;

    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }

    public Mascota findById(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    public Mascota save(Mascota mascota, Long duenoId) {
        Dueno dueno = duenoRepository.findById(duenoId).orElse(null);
        if (dueno == null) {
            return null;
        }
        mascota.setDueno(dueno);
        return mascotaRepository.save(mascota);
    }

    public Mascota saveByCC(Mascota mascota, int cedula){
        Dueno dueno = duenoRepository.findByCedula(cedula).orElse(null);
        if (dueno == null) {
            return null;
        }
        mascota.setDueno(dueno);
        return mascotaRepository.save(mascota);
    }

    public void deleteById(Long id) {
        mascotaRepository.deleteById(id);
    }
}
