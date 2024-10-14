package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.AdministradorDTO;
import com.example.project.project_io.service.AdministradorService;
import com.example.project.project_io.vo.AdministradorVO;
import com.example.project.project_io.vo.AdministradorUpdateVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    // Método para guardar un administrador
    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody AdministradorVO vO) {
        return ResponseEntity.ok(administradorService.save(vO).toString());
    }

    // Método para eliminar un administrador por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) {
        administradorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Método para actualizar un administrador
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                       @Valid @RequestBody AdministradorUpdateVO vO) {
        administradorService.update(id, vO);
        return ResponseEntity.noContent().build();
    }

    // Método para obtener un administrador por ID
    @GetMapping("/{id}")
    public ResponseEntity<AdministradorDTO> getById(@Valid @NotNull @PathVariable("id") Long id) {
        AdministradorDTO administrador = administradorService.getById(id);
        return ResponseEntity.ok(administrador);
    }

    // Método para obtener todos los administradores sin paginación
    @GetMapping("/todos")
    public ResponseEntity<List<AdministradorDTO>> getAllAdministradores() {
        List<AdministradorDTO> administradores = administradorService.getAllAdministradores();
        return ResponseEntity.ok(administradores);
    }
}