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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario save(@Valid @RequestBody UsuarioVO vO) {
        return usuarioService.save(vO);
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        usuarioService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody UsuarioVO vO) {
        usuarioService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return usuarioService.getById(id);
    }

    @GetMapping
    public Page<UsuarioDTO> query(Pageable pageable) {
        return usuarioService.query(pageable);
    }

    @GetMapping("/buscar-por-email")
    public UsuarioDTO findByEmail(@RequestParam String email) {
        return usuarioService.findByEmail(email);
    }
}