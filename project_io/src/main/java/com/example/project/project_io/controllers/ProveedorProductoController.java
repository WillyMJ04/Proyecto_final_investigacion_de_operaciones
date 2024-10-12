package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ProveedorProductoDTO;
import com.example.project.project_io.vo.ProveedorProductoVO;
import com.example.project.project_io.service.ProveedorProductoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/proveedor_producto")

public class ProveedorProductoController {
       @Autowired
    private ProveedorProductoService proveedorProductoService;

    @PostMapping
    public String save(@Valid @RequestBody ProveedorProductoVO vO) {
        return proveedorProductoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        proveedorProductoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id, @Valid @RequestBody ProveedorProductoVO vO) {
        proveedorProductoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ProveedorProductoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return proveedorProductoService.getById(id);
    }
}
