package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.HorarioDisponibilidadDTO;
import com.example.project.project_io.service.HorarioDisponibilidadService;
import com.example.project.project_io.vo.HorarioDisponibilidadVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity; // Import agregado
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/horario-disponibilidad")
public class HorarioDisponibilidadController {

    @Autowired
    private HorarioDisponibilidadService horarioDisponibilidadService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody HorarioDisponibilidadVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(horarioDisponibilidadService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        horarioDisponibilidadService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody HorarioDisponibilidadVO vO) { // Cambiado a ResponseEntity
        horarioDisponibilidadService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioDisponibilidadDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        HorarioDisponibilidadDTO horarioDisponibilidad = horarioDisponibilidadService.getById(id);
        return ResponseEntity.ok(horarioDisponibilidad); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<HorarioDisponibilidadDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(horarioDisponibilidadService.query(pageable)); // Cambiado a ResponseEntity
    }
}