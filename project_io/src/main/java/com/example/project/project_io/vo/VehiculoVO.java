package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Data
public class VehiculoVO {

    @NotNull(message = "La capacidad de carga es obligatoria")
    private BigDecimal capacidadDeCarga;

    @NotNull(message = "La capacidad de volumen es obligatoria")
    private BigDecimal capacidadVolumen;

    @NotNull(message = "La licencia es obligatoria")
    private String licencia;

    private String disponibilidadHoraria;

    @NotNull(message = "El ID del tipo de vehículo es obligatorio")
    private Long tipoVehiculoId;

    @NotNull(message = "El ID del tipo de licencia es obligatorio")
    private Long tipoLicenciaId;
}