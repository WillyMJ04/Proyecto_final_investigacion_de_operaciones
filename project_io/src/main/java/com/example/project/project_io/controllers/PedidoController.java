package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.PedidoDTO;
import com.example.project.project_io.service.PedidoService;
import com.example.project.project_io.vo.PedidoVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public String save(@Valid @RequestBody PedidoVO vO) {
        return pedidoService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        pedidoService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PedidoVO vO) {
        pedidoService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PedidoDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return pedidoService.getById(id);
    }

    @GetMapping
    public Page<PedidoDTO> query(Pageable pageable) {
        return pedidoService.query(pageable);
    }
}