package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class TipoLicenciaVO {

    @NotNull(message = "El nombre del tipo de licencia es obligatorio")
    private String nombre;

    private String descripcion;
}