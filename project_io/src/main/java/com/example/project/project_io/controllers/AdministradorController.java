package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.AdministradorDTO;
import com.example.project.project_io.service.AdministradorService;
import com.example.project.project_io.vo.AdministradorVO;
import com.example.project.project_io.vo.AdministradorUpdateVO;
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
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    // Método para guardar un administrador
    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody AdministradorVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(administradorService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    // Método para eliminar un administrador por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        administradorService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    // Método para actualizar un administrador
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody AdministradorUpdateVO vO) { // Cambiado a ResponseEntity
        administradorService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    // Método para obtener un administrador por ID
    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        AdministradorDTO administrador = administradorService.getById(id);
        return ResponseEntity.ok(administrador); // Cambiado a ResponseEntity
    }

    // Método para realizar consultas paginadas de administradores
    @GetMapping
    public ResponseEntity<Page<AdministradorDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(administradorService.query(pageable)); // Cambiado a ResponseEntity
    }
}