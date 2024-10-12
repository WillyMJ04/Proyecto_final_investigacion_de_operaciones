package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ProveedorDTO;
import com.example.project.project_io.service.ProveedorService;

import com.example.project.project_io.service.ProveedorUpdateVO;
import com.example.project.project_io.vo.ProveedorVO;
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
@RequestMapping("/proveedorProducto")
public class ProveedorProductoController {

    @Autowired
    private ProveedorService proveedorService;

    // Método para guardar un proveedor
    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody ProveedorVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(proveedorService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    // Método para eliminar un proveedor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        proveedorService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    // Método para actualizar un proveedor por ID
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody ProveedorUpdateVO vO) { // Cambiado a ResponseEntity
        proveedorService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    // Método para obtener un proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        ProveedorDTO proveedor = proveedorService.getById(id);
        return ResponseEntity.ok(proveedor); // Cambiado a ResponseEntity
    }

    // Método para realizar consultas paginadas de proveedores
    @GetMapping
    public ResponseEntity<Page<ProveedorDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(proveedorService.query(pageable)); // Cambiado a ResponseEntity
    }
}