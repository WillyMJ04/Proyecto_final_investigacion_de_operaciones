package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.RutaDTO;
import com.example.project.project_io.service.RutaService;
import com.example.project.project_io.vo.RutaVO;
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
@RequestMapping("/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody RutaVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(rutaService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        rutaService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody RutaVO vO) { // Cambiado a ResponseEntity
        rutaService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        RutaDTO ruta = rutaService.getById(id);
        return ResponseEntity.ok(ruta); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<RutaDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(rutaService.query(pageable)); // Cambiado a ResponseEntity
    }
}