package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Data
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idUsuario;

    @NotNull
    private String nombre;

    @NotNull
    private String email;

    @NotNull
    private Long rolId;
}
