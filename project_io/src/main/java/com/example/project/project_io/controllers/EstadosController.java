package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.EstadosDTO;
import com.example.project.project_io.service.EstadosService;
import com.example.project.project_io.vo.EstadosVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estados")
public class EstadosController {

    @Autowired
    private EstadosService estadosService;

    @PostMapping
    public String save(@Valid @RequestBody EstadosVO vO) {
        return estadosService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        estadosService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody EstadosVO vO) {
        estadosService.update(id, vO);
    }

    @GetMapping("/{id}")
    public EstadosDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return estadosService.getById(id);
    }

    @GetMapping
    public Page<EstadosDTO> query(Pageable pageable) {
        return estadosService.query(pageable);
    }

    @GetMapping("/buscar-por-nombre")
    public EstadosDTO findByNombre(@RequestParam String nombre) {
        return estadosService.findByNombre(nombre);
    }
}