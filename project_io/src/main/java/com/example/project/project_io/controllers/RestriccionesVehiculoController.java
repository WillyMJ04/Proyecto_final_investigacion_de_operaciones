package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.RestriccionesVehiculoDTO;
import com.example.project.project_io.service.RestriccionesVehiculoService;
import com.example.project.project_io.vo.RestriccionesVehiculoVO;
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
@RequestMapping("/restricciones-vehiculo")
public class RestriccionesVehiculoController {

    @Autowired
    private RestriccionesVehiculoService restriccionesVehiculoService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody RestriccionesVehiculoVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(restriccionesVehiculoService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        restriccionesVehiculoService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody RestriccionesVehiculoVO vO) { // Cambiado a ResponseEntity
        restriccionesVehiculoService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestriccionesVehiculoDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        RestriccionesVehiculoDTO restricciones = restriccionesVehiculoService.getById(id);
        return ResponseEntity.ok(restricciones); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<RestriccionesVehiculoDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(restriccionesVehiculoService.query(pageable)); // Cambiado a ResponseEntity
    }
}