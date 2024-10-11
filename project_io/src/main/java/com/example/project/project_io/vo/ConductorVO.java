package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
public class ConductorVO {

    @NotNull(message = "El nombre del conductor es obligatorio")
    private String nombre;

    private LocalDate fechaNacimiento;

    @NotNull(message = "El número de documento es obligatorio")
    private String numeroDocumento;

    private String telefono;

    private String direccion;

    @NotNull(message = "El tipo de licencia es obligatorio")
    private Long tipoLicenciaId;
}