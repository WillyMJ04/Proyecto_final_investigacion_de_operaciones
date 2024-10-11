package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class EstadosVO {

    @NotNull(message = "El nombre del estado es obligatorio")
    private String nombre;

    private String descripcion;
}