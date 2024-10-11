package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Data
public class TipoVehiculoVO {

    @NotNull(message = "El nombre del tipo de vehículo es obligatorio")
    private String nombre;

    @NotNull(message = "El consumo por kilómetro es obligatorio")
    private BigDecimal consumoPorKm;
}