package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class VehiculoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idVehiculo;

    @NotNull
    private BigDecimal capacidadDeCarga;

    @NotNull
    private BigDecimal capacidadVolumen;

    @NotNull
    private String licencia;

    private String disponibilidadHoraria;

    @NotNull
    private Long tipoVehiculoId;

    @NotNull
    private Long tipoLicenciaId;
}