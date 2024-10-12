package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ParadaDTO;
import com.example.project.project_io.service.ParadaService;
import com.example.project.project_io.vo.ParadaVO;
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
@RequestMapping("/paradas")
public class ParadaController {

    @Autowired
    private ParadaService paradaService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody ParadaVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(paradaService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        paradaService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody ParadaVO vO) { // Cambiado a ResponseEntity
        paradaService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParadaDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        ParadaDTO parada = paradaService.getById(id);
        return ResponseEntity.ok(parada); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<ParadaDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(paradaService.query(pageable)); // Cambiado a ResponseEntity
    }
}