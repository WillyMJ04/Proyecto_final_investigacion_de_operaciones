package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.TipoVehiculoDTO;
import com.example.project.project_io.service.TipoVehiculoService;
import com.example.project.project_io.vo.TipoVehiculoVO;
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
@RequestMapping("/tipo-vehiculo")
public class TipoVehiculoController {

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody TipoVehiculoVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(tipoVehiculoService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        tipoVehiculoService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody TipoVehiculoVO vO) { // Cambiado a ResponseEntity
        tipoVehiculoService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculoDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        TipoVehiculoDTO tipoVehiculo = tipoVehiculoService.getById(id);
        return ResponseEntity.ok(tipoVehiculo); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<TipoVehiculoDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(tipoVehiculoService.query(pageable)); // Cambiado a ResponseEntity
    }
}