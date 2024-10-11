package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.HorarioDisponibilidadDTO;
import com.example.project.project_io.service.HorarioDisponibilidadService;
import com.example.project.project_io.vo.HorarioDisponibilidadVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/horario-disponibilidad")
public class HorarioDisponibilidadController {

    @Autowired
    private HorarioDisponibilidadService horarioDisponibilidadService;

    @PostMapping
    public String save(@Valid @RequestBody HorarioDisponibilidadVO vO) {
        return horarioDisponibilidadService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        horarioDisponibilidadService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody HorarioDisponibilidadVO vO) {
        horarioDisponibilidadService.update(id, vO);
    }

    @GetMapping("/{id}")
    public HorarioDisponibilidadDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return horarioDisponibilidadService.getById(id);
    }

    @GetMapping
    public Page<HorarioDisponibilidadDTO> query(Pageable pageable) {
        return horarioDisponibilidadService.query(pageable);
    }
}