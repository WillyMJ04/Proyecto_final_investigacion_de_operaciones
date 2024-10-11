package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class ClienteVO {
    @NotNull(message = "El nombre del cliente es obligatorio")
    private String nombre;

    private String direccion;

    private String telefono;

    @NotNull(message = "El email del cliente es obligatorio")
    private String email;
}
