package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ConductorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    private String nombre;

    private LocalDate fechaNacimiento;

    @NotNull
    private String numeroDocumento;

    private String telefono;

    private String direccion;

    @NotNull
    private Long tipoLicenciaId;
}