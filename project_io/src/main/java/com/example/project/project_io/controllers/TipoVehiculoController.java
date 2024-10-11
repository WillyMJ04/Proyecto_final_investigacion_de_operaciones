package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.TipoVehiculoDTO;
import com.example.project.project_io.service.TipoVehiculoService;
import com.example.project.project_io.vo.TipoVehiculoVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/tipo-vehiculo")
public class TipoVehiculoController {

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @PostMapping
    public String save(@Valid @RequestBody TipoVehiculoVO vO) {
        return tipoVehiculoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        tipoVehiculoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TipoVehiculoVO vO) {
        tipoVehiculoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TipoVehiculoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return tipoVehiculoService.getById(id);
    }

    @GetMapping
    public Page<TipoVehiculoDTO> query(Pageable pageable) {
        return tipoVehiculoService.query(pageable);
    }
}