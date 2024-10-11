
package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ConductorPedidoDTO;
import com.example.project.project_io.service.ConductorPedidoService;
import com.example.project.project_io.vo.ConductorPedidoVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/conductor-pedido")
public class ConductorPedidoController {

    @Autowired
    private ConductorPedidoService conductorPedidoService;

    @PostMapping
    public String save(@Valid @RequestBody ConductorPedidoVO vO) {
        return conductorPedidoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        conductorPedidoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ConductorPedidoVO vO) {
        conductorPedidoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ConductorPedidoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return conductorPedidoService.getById(id);
    }

    @GetMapping("/buscar")
    public ConductorPedidoDTO findByConductorAndPedido(@RequestParam Long idConductor, @RequestParam Long idPedido) {
        return conductorPedidoService.findByConductorIdAndPedidoId(idConductor, idPedido);
    }
}