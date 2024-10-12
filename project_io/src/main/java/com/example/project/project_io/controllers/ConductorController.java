package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ConductorDTO;
import com.example.project.project_io.service.ConductorService;
import com.example.project.project_io.vo.ConductorVO;
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
@RequestMapping("/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody ConductorVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(conductorService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        conductorService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody ConductorVO vO) { // Cambiado a ResponseEntity
        conductorService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConductorDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        ConductorDTO conductor = conductorService.getById(id);
        return ResponseEntity.ok(conductor); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<ConductorDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(conductorService.query(pageable)); // Cambiado a ResponseEntity
    }

    @GetMapping("/buscar-por-documento")
    public ResponseEntity<ConductorDTO> findByNumeroDocumento(@RequestParam String numeroDocumento) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(conductorService.findByNumeroDocumento(numeroDocumento)); // Cambiado a ResponseEntity
    }
}