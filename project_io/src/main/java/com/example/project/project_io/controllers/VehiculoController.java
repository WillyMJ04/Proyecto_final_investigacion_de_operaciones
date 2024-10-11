package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.VehiculoDTO;
import com.example.project.project_io.service.VehiculoService;
import com.example.project.project_io.vo.VehiculoVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping
    public String save(@Valid @RequestBody VehiculoVO vO) {
        return vehiculoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        vehiculoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody VehiculoVO vO) {
        vehiculoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public VehiculoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return vehiculoService.getById(id);
    }

    @GetMapping
    public Page<VehiculoDTO> query(Pageable pageable) {
        return vehiculoService.query(pageable);
    }
}