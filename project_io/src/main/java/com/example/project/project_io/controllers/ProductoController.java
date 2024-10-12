package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ProductoDTO;
import com.example.project.project_io.vo.ProductoVO;
import com.example.project.project_io.vo.ProductoUpdateVO;
import com.example.project.project_io.service.ProductoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Import agregado
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Endpoint para guardar un producto
    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody ProductoVO vO) {
        return ResponseEntity.ok(productoService.save(vO).toString());
    }

    // Endpoint para eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para actualizar un producto por ID
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                       @Valid @RequestBody ProductoUpdateVO vO) {
        productoService.update(id, vO);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getById(@Valid @NotNull @PathVariable("id") Long id) {
        ProductoDTO producto = productoService.getById(id);
        return ResponseEntity.ok(producto);
    }

    // Endpoint para obtener todos los productos (sin paginación)
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        List<ProductoDTO> productos = productoService.query();
        return ResponseEntity.ok(productos);
    }
}