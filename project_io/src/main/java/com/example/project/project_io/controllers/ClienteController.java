package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.ClienteDTO;
import com.example.project.project_io.service.ClienteService;
import com.example.project.project_io.vo.ClienteVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Método para guardar un cliente
    @PostMapping
    public String save(@Valid @RequestBody ClienteVO vO) {
        return clienteService.save(vO).toString();
    }

    // Método para eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        clienteService.delete(id);
    }

    // Método para actualizar un cliente
    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody ClienteVO vO) {
        clienteService.update(id, vO);
    }

    // Método para obtener un cliente por ID
    @GetMapping("/{id}")
    public ClienteDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return clienteService.getById(id);
    }

    // Método para obtener todos los clientes con paginación
    @GetMapping
    public Page<ClienteDTO> query(Pageable pageable) {
        return clienteService.query(pageable);
    }
}