package com.example.parcial.demo.controllers;

import com.example.parcial.demo.models.Mascota;
import com.example.parcial.demo.responses.ResponseHandler;
import com.example.parcial.demo.services.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<Mascota> findAll() {
        return mascotaService.findAll();
    }

    @GetMapping("/{id}")
    public Mascota findById(@PathVariable Long id) {
        return mascotaService.findById(id);
    }

    @PostMapping("/saveById/{duenoId}")
    public ResponseEntity<Object> saveById(@RequestBody Mascota mascota, @PathVariable Long duenoId) {
        try {
            Mascota result = mascotaService.save(mascota, duenoId);
            if (result != null) {
                return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, result);
            }

            return ResponseHandler.generateResponse("NOT EXISTS Dueno", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping("/saveByCC/{cedula}")
    public ResponseEntity<Object> saveByCC(@RequestBody Mascota mascota, @PathVariable int cedula) {
        try {
            Mascota result = mascotaService.saveByCC(mascota, cedula);
            if (result != null) {
                return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, result);
            }

            return ResponseHandler.generateResponse("NOT EXISTS Dueno", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        mascotaService.deleteById(id);
    }
}
