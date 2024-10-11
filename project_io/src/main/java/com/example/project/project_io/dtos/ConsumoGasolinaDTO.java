package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ConsumoGasolinaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idConsumo;

    @NotNull
    private String tipoGasolina;

    @NotNull
    private BigDecimal precioPorLitro;

    @NotNull
    private BigDecimal litrosConsumidos;

    @NotNull
    private Long idVehiculo;

    @NotNull
    private Long idRuta;
}