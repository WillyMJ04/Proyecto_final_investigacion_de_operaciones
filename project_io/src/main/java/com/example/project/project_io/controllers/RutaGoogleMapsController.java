package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.RutaGoogleMapsDTO;
import com.example.project.project_io.service.RutaGoogleMapsService;
import com.example.project.project_io.vo.RutaGoogleMapsVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/rutas-google-maps")
public class RutaGoogleMapsController {

    @Autowired
    private RutaGoogleMapsService rutaGoogleMapsService;

    @PostMapping
    public String save(@Valid @RequestBody RutaGoogleMapsVO vO) {
        return rutaGoogleMapsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        rutaGoogleMapsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody RutaGoogleMapsVO vO) {
        rutaGoogleMapsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public RutaGoogleMapsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return rutaGoogleMapsService.getById(id);
    }

    @GetMapping
    public Page<RutaGoogleMapsDTO> query(Pageable pageable) {
        return rutaGoogleMapsService.query(pageable);
    }
}