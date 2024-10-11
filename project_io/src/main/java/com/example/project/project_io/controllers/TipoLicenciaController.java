package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.TipoLicenciaDTO;
import com.example.project.project_io.service.TipoLicenciaService;
import com.example.project.project_io.vo.TipoLicenciaVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/tipo-licencia")
public class TipoLicenciaController {

    @Autowired
    private TipoLicenciaService tipoLicenciaService;

    @PostMapping
    public String save(@Valid @RequestBody TipoLicenciaVO vO) {
        return tipoLicenciaService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        tipoLicenciaService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody TipoLicenciaVO vO) {
        tipoLicenciaService.update(id, vO);
    }

    @GetMapping("/{id}")
    public TipoLicenciaDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return tipoLicenciaService.getById(id);
    }

    @GetMapping
    public Page<TipoLicenciaDTO> query(Pageable pageable) {
        return tipoLicenciaService.query(pageable);
    }
}