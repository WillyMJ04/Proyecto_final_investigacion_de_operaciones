package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.RutaGoogleMapsDTO;
import com.example.project.project_io.service.RutaGoogleMapsService;
import com.example.project.project_io.vo.RutaGoogleMapsVO;
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
@RequestMapping("/rutas-google-maps")
public class RutaGoogleMapsController {

    @Autowired
    private RutaGoogleMapsService rutaGoogleMapsService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody RutaGoogleMapsVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(rutaGoogleMapsService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        rutaGoogleMapsService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody RutaGoogleMapsVO vO) { // Cambiado a ResponseEntity
        rutaGoogleMapsService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaGoogleMapsDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        RutaGoogleMapsDTO ruta = rutaGoogleMapsService.getById(id);
        return ResponseEntity.ok(ruta); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<RutaGoogleMapsDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(rutaGoogleMapsService.query(pageable)); // Cambiado a ResponseEntity
    }
}