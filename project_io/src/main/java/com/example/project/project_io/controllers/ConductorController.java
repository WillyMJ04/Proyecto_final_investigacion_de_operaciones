package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ConductorDTO;
import com.example.project.project_io.service.ConductorService;
import com.example.project.project_io.vo.ConductorVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @PostMapping
    public String save(@Valid @RequestBody ConductorVO vO) {
        return conductorService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        conductorService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ConductorVO vO) {
        conductorService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ConductorDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return conductorService.getById(id);
    }

    @GetMapping
    public Page<ConductorDTO> query(Pageable pageable) {
        return conductorService.query(pageable);
    }

    @GetMapping("/buscar-por-documento")
    public ConductorDTO findByNumeroDocumento(@RequestParam String numeroDocumento) {
        return conductorService.findByNumeroDocumento(numeroDocumento);
    }
}