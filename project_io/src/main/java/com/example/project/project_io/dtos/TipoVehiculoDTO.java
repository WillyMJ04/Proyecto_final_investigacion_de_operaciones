package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TipoVehiculoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idTipoVehiculo;

    @NotNull
    private String nombre;

    @NotNull
    private BigDecimal consumoPorKm;
}