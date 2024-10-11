package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.DetallePedidoDTO;
import com.example.project.project_io.service.DetallePedidoService;
import com.example.project.project_io.vo.DetallePedidoVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/detalle-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @PostMapping
    public String save(@Valid @RequestBody DetallePedidoVO vO) {
        return detallePedidoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        detallePedidoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody DetallePedidoVO vO) {
        detallePedidoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public DetallePedidoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return detallePedidoService.getById(id);
    }

    @GetMapping
    public Page<DetallePedidoDTO> query(Pageable pageable) {
        return detallePedidoService.query(pageable);
    }
}