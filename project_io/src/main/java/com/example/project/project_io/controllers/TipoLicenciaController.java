package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.TipoLicenciaDTO;
import com.example.project.project_io.service.TipoLicenciaService;
import com.example.project.project_io.vo.TipoLicenciaVO;
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
@RequestMapping("/tipo-licencia")
public class TipoLicenciaController {

    @Autowired
    private TipoLicenciaService tipoLicenciaService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody TipoLicenciaVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(tipoLicenciaService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        tipoLicenciaService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody TipoLicenciaVO vO) { // Cambiado a ResponseEntity
        tipoLicenciaService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoLicenciaDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        TipoLicenciaDTO tipoLicencia = tipoLicenciaService.getById(id);
        return ResponseEntity.ok(tipoLicencia); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<TipoLicenciaDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(tipoLicenciaService.query(pageable)); // Cambiado a ResponseEntity
    }
}