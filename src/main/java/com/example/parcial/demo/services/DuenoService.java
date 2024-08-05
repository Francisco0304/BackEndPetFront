package com.example.parcial.demo.services;

import com.example.parcial.demo.models.Dueno;
import com.example.parcial.demo.repositories.DuenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenoService {
    @Autowired
    private DuenoRepository duenoRepository;

    public List<Dueno> findAll() {
        return duenoRepository.findAll();
    }

    public Dueno findById(Long id) {
        return duenoRepository.findById(id).orElse(null);
    }

    public Dueno save(Dueno dueno) {
        return duenoRepository.save(dueno);
    }

    public void deleteById(Long id) {
        duenoRepository.deleteById(id);
    }
}
