package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ParadaDTO;

import com.example.project.project_io.service.ParadaService;
import com.example.project.project_io.vo.ParadaVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/paradas")
public class ParadaController {

    @Autowired
    private ParadaService paradaService;

    @PostMapping
    public String save(@Valid @RequestBody ParadaVO vO) {
        return paradaService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        paradaService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ParadaVO vO) {
        paradaService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ParadaDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return paradaService.getById(id);
    }

    @GetMapping
    public Page<ParadaDTO> query(Pageable pageable) {
        return paradaService.query(pageable);
    }
}