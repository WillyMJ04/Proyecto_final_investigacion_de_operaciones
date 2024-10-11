package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Data
public class RestriccionesVehiculoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idRestriccion;

    private String restriccionParadas;

    private String restriccionVisitas;

    @NotNull
    private Long idVehiculo;
}
