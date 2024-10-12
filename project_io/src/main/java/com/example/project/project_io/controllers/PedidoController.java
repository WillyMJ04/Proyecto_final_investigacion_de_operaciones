package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.PedidoDTO;
import com.example.project.project_io.service.PedidoService;
import com.example.project.project_io.vo.PedidoVO;
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
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody PedidoVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(pedidoService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        pedidoService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody PedidoVO vO) { // Cambiado a ResponseEntity
        pedidoService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        PedidoDTO pedido = pedidoService.getById(id);
        return ResponseEntity.ok(pedido); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<PedidoDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(pedidoService.query(pageable)); // Cambiado a ResponseEntity
    }
}