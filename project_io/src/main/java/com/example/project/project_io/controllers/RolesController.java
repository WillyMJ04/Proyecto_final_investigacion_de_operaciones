package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.RolesDTO;
import com.example.project.project_io.service.RolesService;
import com.example.project.project_io.vo.RolesVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @PostMapping
    public String save(@Valid @RequestBody RolesVO vO) {
        return rolesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        rolesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody RolesVO vO) {
        rolesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public RolesDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return rolesService.getById(id);
    }

    @GetMapping
    public Page<RolesDTO> query(Pageable pageable) {
        return rolesService.query(pageable);
    }

    @GetMapping("/buscar-por-nombre")
    public RolesDTO findByNombre(@RequestParam String nombre) {
        return rolesService.findByNombre(nombre);
    }
}