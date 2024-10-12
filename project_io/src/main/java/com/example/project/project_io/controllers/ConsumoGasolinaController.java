package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ConsumoGasolinaDTO;
import com.example.project.project_io.service.ConsumoGasolinaService;
import com.example.project.project_io.vo.ConsumoGasolinaVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity; // Import agregado
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/consumo-gasolina")
public class ConsumoGasolinaController {

    @Autowired
    private ConsumoGasolinaService consumoGasolinaService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody ConsumoGasolinaVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(consumoGasolinaService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        consumoGasolinaService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody ConsumoGasolinaVO vO) { // Cambiado a ResponseEntity
        consumoGasolinaService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoGasolinaDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        ConsumoGasolinaDTO consumoGasolina = consumoGasolinaService.getById(id);
        return ResponseEntity.ok(consumoGasolina); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<ConsumoGasolinaDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(consumoGasolinaService.query(pageable)); // Cambiado a ResponseEntity
    }
}