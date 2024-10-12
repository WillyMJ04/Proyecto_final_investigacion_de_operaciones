package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.RestriccionesDeEntregaDTO;
import com.example.project.project_io.service.RestriccionesDeEntregaService;
import com.example.project.project_io.vo.RestriccionesDeEntregaVO;
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
@RequestMapping("/restricciones-de-entrega")
public class RestriccionesDeEntregaController {

    @Autowired
    private RestriccionesDeEntregaService restriccionesDeEntregaService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody RestriccionesDeEntregaVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(restriccionesDeEntregaService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        restriccionesDeEntregaService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody RestriccionesDeEntregaVO vO) { // Cambiado a ResponseEntity
        restriccionesDeEntregaService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestriccionesDeEntregaDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        RestriccionesDeEntregaDTO restricciones = restriccionesDeEntregaService.getById(id);
        return ResponseEntity.ok(restricciones); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<RestriccionesDeEntregaDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(restriccionesDeEntregaService.query(pageable)); // Cambiado a ResponseEntity
    }
}