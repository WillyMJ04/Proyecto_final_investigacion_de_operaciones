package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RutaVO {

    @NotNull(message = "La fecha de la ruta es obligatoria")
    private LocalDate fechaRuta;

    @NotNull(message = "La hora de inicio es obligatoria")
    private LocalTime horaInicio;

    private LocalTime horaFin;

    private BigDecimal kilometrajeRecorrido;

    @NotNull(message = "El ID del conductor es obligatorio")
    private Long idConductor;

    @NotNull(message = "El ID del vehículo es obligatorio")
    private Long idVehiculo;

    @NotNull(message = "El ID del estado es obligatorio")
    private Long estadoId;

    private String coordenadasInicio;

    private String coordenadasFin;

    private BigDecimal distancia;

    private LocalTime tiempoEstimado;
}