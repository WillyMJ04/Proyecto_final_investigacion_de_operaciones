package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.RutaDTO;
import com.example.project.project_io.service.RutaService;
import com.example.project.project_io.vo.RutaVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @PostMapping
    public String save(@Valid @RequestBody RutaVO vO) {
        return rutaService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        rutaService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody RutaVO vO) {
        rutaService.update(id, vO);
    }

    @GetMapping("/{id}")
    public RutaDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return rutaService.getById(id);
    }

    @GetMapping
    public Page<RutaDTO> query(Pageable pageable) {
        return rutaService.query(pageable);
    }
}