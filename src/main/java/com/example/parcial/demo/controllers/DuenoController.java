package com.example.parcial.demo.controllers;

import com.example.parcial.demo.models.Dueno;
import com.example.parcial.demo.services.DuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duenos")
public class DuenoController {
    @Autowired
    private DuenoService duenoService;

    @GetMapping
    public List<Dueno> findAll() {
        return duenoService.findAll();
    }

    @GetMapping("/{id}")
    public Dueno findById(@PathVariable Long id) {
        return duenoService.findById(id);
    }

    @PostMapping
    public Dueno save(@RequestBody Dueno dueno) {
        return duenoService.save(dueno);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        duenoService.deleteById(id);
    }
}
