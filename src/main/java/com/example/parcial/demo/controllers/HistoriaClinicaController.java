package com.example.parcial.demo.controllers;

import com.example.parcial.demo.DTO.HistoriaClinicaDTO;
import com.example.parcial.demo.models.HistoriaClinica;
import com.example.parcial.demo.responses.ResponseHandler;
import com.example.parcial.demo.services.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historias-clinicas")
public class HistoriaClinicaController {
    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @GetMapping
    public List<HistoriaClinica> findAll() {
        return historiaClinicaService.findAll();
    }

    @GetMapping("/{id}")
    public HistoriaClinica findById(@PathVariable Long id) {
        return historiaClinicaService.findById(id);
    }

    @PostMapping("/{mascotaId}")
    public ResponseEntity<Object> save(@RequestBody HistoriaClinica historiaClinica, @PathVariable Long mascotaId) {
        try {
            HistoriaClinica result = historiaClinicaService.save(historiaClinica, mascotaId);
            if (result != null) {
                return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, result);
            }

            return ResponseHandler.generateResponse("NOT EXISTS Mascota", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        historiaClinicaService.deleteById(id);
    }

    @GetMapping("/mascota/{mascotaId}")
    public ResponseEntity<Object> findByMascotaId(@PathVariable Long mascotaId) {
        try {
            List<HistoriaClinica> historiaClinicas = historiaClinicaService.findByMascotaId(mascotaId);

            if (historiaClinicas != null && !historiaClinicas.isEmpty()) {
                // Convertir a DTOs
                List<HistoriaClinicaDTO> result = historiaClinicas.stream()
                        .map(hc -> new HistoriaClinicaDTO(
                                hc.getId(),
                                hc.getDescripcion(),
                                hc.getFecha(),
                                hc.getTipoServicio()
                        ))
                        .collect(Collectors.toList());

                return ResponseHandler.generateResponse("Success OK", HttpStatus.OK, result);
            }

            return ResponseHandler.generateResponse("No historias clínicas found for this mascota", HttpStatus.NOT_FOUND, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
