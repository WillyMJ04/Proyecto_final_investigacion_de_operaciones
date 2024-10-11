package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class RestriccionesVehiculoVO {

    private String restriccionParadas;

    private String restriccionVisitas;

    @NotNull(message = "El ID del vehículo es obligatorio")
    private Long idVehiculo;
}
