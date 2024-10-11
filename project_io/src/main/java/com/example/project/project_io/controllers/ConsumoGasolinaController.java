package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ConsumoGasolinaDTO;
import com.example.project.project_io.service.ConsumoGasolinaService;
import com.example.project.project_io.vo.ConsumoGasolinaVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/consumo-gasolina")
public class ConsumoGasolinaController {

    @Autowired
    private ConsumoGasolinaService consumoGasolinaService;

    @PostMapping
    public String save(@Valid @RequestBody ConsumoGasolinaVO vO) {
        return consumoGasolinaService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        consumoGasolinaService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ConsumoGasolinaVO vO) {
        consumoGasolinaService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ConsumoGasolinaDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return consumoGasolinaService.getById(id);
    }

    @GetMapping
    public Page<ConsumoGasolinaDTO> query(Pageable pageable) {
        return consumoGasolinaService.query(pageable);
    }
}