package com.example.project.project_io.controllers;
import com.example.project.project_io.dtos.RestriccionesDeEntregaDTO;
import com.example.project.project_io.service.RestriccionesDeEntregaService;
import com.example.project.project_io.vo.RestriccionesDeEntregaVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/restricciones-de-entrega")
public class RestriccionesDeEntregaController {

    @Autowired
    private RestriccionesDeEntregaService restriccionesDeEntregaService;

    @PostMapping
    public String save(@Valid @RequestBody RestriccionesDeEntregaVO vO) {
        return restriccionesDeEntregaService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        restriccionesDeEntregaService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody RestriccionesDeEntregaVO vO) {
        restriccionesDeEntregaService.update(id, vO);
    }

    @GetMapping("/{id}")
    public RestriccionesDeEntregaDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return restriccionesDeEntregaService.getById(id);
    }

    @GetMapping
    public Page<RestriccionesDeEntregaDTO> query(Pageable pageable) {
        return restriccionesDeEntregaService.query(pageable);
    }
}