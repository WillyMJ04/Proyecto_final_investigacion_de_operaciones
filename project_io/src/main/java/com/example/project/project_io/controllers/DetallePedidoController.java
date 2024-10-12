package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.DetallePedidoDTO;
import com.example.project.project_io.service.DetallePedidoService;
import com.example.project.project_io.vo.DetallePedidoVO;
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
@RequestMapping("/detalle-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody DetallePedidoVO vO) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(detallePedidoService.save(vO).toString()); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        detallePedidoService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody DetallePedidoVO vO) { // Cambiado a ResponseEntity
        detallePedidoService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        DetallePedidoDTO detallePedido = detallePedidoService.getById(id);
        return ResponseEntity.ok(detallePedido); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<DetallePedidoDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(detallePedidoService.query(pageable)); // Cambiado a ResponseEntity
    }
}