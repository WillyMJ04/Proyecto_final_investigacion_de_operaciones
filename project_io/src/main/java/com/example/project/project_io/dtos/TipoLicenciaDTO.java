package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Data
public class TipoLicenciaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idTipoLicencia;

    @NotNull
    private String nombre;

    private String descripcion;
}
