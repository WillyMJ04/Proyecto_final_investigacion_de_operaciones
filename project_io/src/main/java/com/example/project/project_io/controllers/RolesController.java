package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.RolesDTO;
import com.example.project.project_io.service.RolesService;
import com.example.project.project_io.vo.RolesVO;
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
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody RolesVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(rolesService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        rolesService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody RolesVO vO) { // Cambiado a ResponseEntity
        rolesService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        RolesDTO role = rolesService.getById(id);
        return ResponseEntity.ok(role); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<RolesDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(rolesService.query(pageable)); // Cambiado a ResponseEntity
    }

    @GetMapping("/buscar-por-nombre")
    public ResponseEntity<RolesDTO> findByNombre(@RequestParam String nombre) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(rolesService.findByNombre(nombre)); // Cambiado a ResponseEntity
    }
}