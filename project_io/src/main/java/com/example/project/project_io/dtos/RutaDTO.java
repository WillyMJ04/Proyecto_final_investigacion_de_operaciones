package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RutaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idRuta;

    @NotNull
    private LocalDate fechaRuta;

    @NotNull
    private LocalTime horaInicio;

    private LocalTime horaFin;

    private BigDecimal kilometrajeRecorrido;

    @NotNull
    private Long idConductor;

    @NotNull
    private Long idVehiculo;

    @NotNull
    private Long estadoId;

    private String coordenadasInicio;

    private String coordenadasFin;

    private BigDecimal distancia;

    private LocalTime tiempoEstimado;
}