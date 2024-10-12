package com.example.project.project_io.controllers;

import com.example.project.project_io.dtos.UsuarioDTO;
import com.example.project.project_io.entities.Usuario;
import com.example.project.project_io.service.UsuarioService;
import com.example.project.project_io.vo.UsuarioVO;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> save(@Valid @RequestBody UsuarioVO vO) { // Cambiado a ResponseEntity
        Usuario usuario = usuarioService.save(vO);
        return ResponseEntity.ok(usuario); // Cambiado a ResponseEntity
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        usuarioService.delete(id);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @NotNull @PathVariable("id") Long id,
                                        @Valid @RequestBody UsuarioVO vO) { // Cambiado a ResponseEntity
        usuarioService.update(id, vO);
        return ResponseEntity.noContent().build(); // Cambiado a ResponseEntity
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@Valid @NotNull @PathVariable("id") Long id) { // Cambiado a ResponseEntity
        UsuarioDTO usuario = usuarioService.getById(id);
        return ResponseEntity.ok(usuario); // Cambiado a ResponseEntity
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> query(Pageable pageable) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(usuarioService.query(pageable)); // Cambiado a ResponseEntity
    }

    @GetMapping("/buscar-por-email")
    public ResponseEntity<UsuarioDTO> findByEmail(@RequestParam String email) { // Cambiado a ResponseEntity
        return ResponseEntity.ok(usuarioService.findByEmail(email)); // Cambiado a ResponseEntity
    }
}