package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class UsuarioVO {

    @NotNull(message = "El nombre del usuario es obligatorio")
    private String nombre;

    @NotNull(message = "El correo electrónico es obligatorio")
    private String email;

    @NotNull(message = "La contraseña es obligatoria")
    private String contrasena;

    @NotNull(message = "El ID del rol es obligatorio")
    private Long rolId;
}
