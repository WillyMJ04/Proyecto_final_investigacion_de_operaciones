package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Data
public class ConsumoGasolinaVO {

    @NotNull(message = "El tipo de gasolina es obligatorio")
    private String tipoGasolina;

    @NotNull(message = "El precio por litro es obligatorio")
    private BigDecimal precioPorLitro;

    @NotNull(message = "Los litros consumidos son obligatorios")
    private BigDecimal litrosConsumidos;

    @NotNull(message = "El ID del vehículo es obligatorio")
    private Long idVehiculo;

    @NotNull(message = "El ID de la ruta es obligatorio")
    private Long idRuta;
}