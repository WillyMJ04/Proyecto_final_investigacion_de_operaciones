package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class RolesVO {

    @NotNull(message = "El nombre del rol es obligatorio")
    private String nombre;

    private String descripcion;
}