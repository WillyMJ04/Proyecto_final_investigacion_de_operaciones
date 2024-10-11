package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.RestriccionesVehiculoDTO;
import com.example.project.project_io.service.RestriccionesVehiculoService;
import com.example.project.project_io.vo.RestriccionesVehiculoVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/restricciones-vehiculo")
public class RestriccionesVehiculoController {

    @Autowired
    private RestriccionesVehiculoService restriccionesVehiculoService;

    @PostMapping
    public String save(@Valid @RequestBody RestriccionesVehiculoVO vO) {
        return restriccionesVehiculoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        restriccionesVehiculoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody RestriccionesVehiculoVO vO) {
        restriccionesVehiculoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public RestriccionesVehiculoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return restriccionesVehiculoService.getById(id);
    }

    @GetMapping
    public Page<RestriccionesVehiculoDTO> query(Pageable pageable) {
        return restriccionesVehiculoService.query(pageable);
    }
}