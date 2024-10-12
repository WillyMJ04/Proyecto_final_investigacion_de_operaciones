package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ProductoDTO;
import com.example.project.project_io.vo.ProductoVO;
import com.example.project.project_io.vo.ProductoUpdateVO;
import com.example.project.project_io.service.ProductoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/producto")

public class ProductoController {
 @Autowired
    private ProductoService productoService;

    @PostMapping
    public String save(@Valid @RequestBody ProductoVO vO) {
        return productoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        productoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id, @Valid @RequestBody ProductoUpdateVO vO) {
        productoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ProductoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return productoService.getById(id);
    }

    @GetMapping
    public Page<ProductoDTO> query(Pageable pageable) {
        return productoService.query(pageable);
    }

}
