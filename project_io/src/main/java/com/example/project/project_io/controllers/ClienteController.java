package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ClienteDTO;
import com.example.project.project_io.service.ClienteService;
import com.example.project.project_io.vo.ClienteVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Método para guardar un cliente
    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody ClienteVO vO) {
        return ResponseEntity.ok(clienteService.save(vO).toString());
    }

    // Método para eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Método para actualizar un cliente
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                       @Valid @RequestBody ClienteVO vO) {
        clienteService.update(id, vO);
        return ResponseEntity.noContent().build();
    }

    // Método para obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@Valid @NotNull @PathVariable("id") Long id) {
        ClienteDTO cliente = clienteService.getById(id);
        return ResponseEntity.ok(cliente);
    }

    // Método para obtener todos los clientes sin paginación (devuelve una lista)
    @GetMapping("/todos")
    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }
}