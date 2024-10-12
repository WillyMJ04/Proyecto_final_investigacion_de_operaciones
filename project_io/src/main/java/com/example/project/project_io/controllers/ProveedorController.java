package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ProveedorDTO;
import com.example.project.project_io.service.ProveedorService;
import com.example.project.project_io.vo.ProveedorVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // Método para guardar un proveedor
    @PostMapping
    public String save(@Valid @RequestBody ProveedorVO vO) {
        return proveedorService.save(vO).toString();
    }

    // Método para eliminar un proveedor por ID
    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        proveedorService.delete(id);
    }

    // Método para actualizar un proveedor por ID
    @PutMapping("/{id}")
    public <ProveedorUpdateVO> void update(@Valid @NotNull @PathVariable("id") Long id,
                                           @Valid @RequestBody ProveedorUpdateVO vO) {
        proveedorService.update(id, vO);
    }

    // Método para obtener un proveedor por ID
    @GetMapping("/{id}")
    public ProveedorDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return proveedorService.getById(id);
    }

    // Método para realizar consultas paginadas de proveedores
    @GetMapping
    public Page<ProveedorDTO> query(Pageable pageable) {
        return proveedorService.query(pageable);
    }
}