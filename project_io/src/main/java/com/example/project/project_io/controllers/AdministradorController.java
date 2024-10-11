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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    // Método para guardar un administrador


    // Método para eliminar un administrador por ID
    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        administradorService.delete(id);
    }

    // Método para actualizar un administrador
    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody AdministradorUpdateVO vO) {
        administradorService.update(id, vO);
    }

    // Método para obtener un administrador por ID
    @GetMapping("/{id}")
    public AdministradorDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return administradorService.getById(id);
    }

    // Método para realizar consultas paginadas de administradores
    @GetMapping
    public Page<AdministradorDTO> query(Pageable pageable) {
        return administradorService.query(pageable);
    }
}