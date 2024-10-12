package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.VehiculoDTO;
import com.example.project.project_io.service.VehiculoService;
import com.example.project.project_io.vo.VehiculoVO;
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
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody VehiculoVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(vehiculoService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        vehiculoService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody VehiculoVO vO) { // Cambiado a ResponseEntity
        vehiculoService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        VehiculoDTO vehiculo = vehiculoService.getById(id);
        return ResponseEntity.ok(vehiculo); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<VehiculoDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(vehiculoService.query(pageable)); // Cambiado a ResponseEntity
    }
}