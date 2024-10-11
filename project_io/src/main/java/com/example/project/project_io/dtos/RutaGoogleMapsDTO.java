package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;

@Data
public class RutaGoogleMapsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idRutaGmaps;

    @NotNull
    private String coordenadasOrigen;

    @NotNull
    private String coordenadasDestino;

    @NotNull
    private BigDecimal distancia;

    @NotNull
    private Duration duracion;

    @NotNull
    private Long idVehiculo;

    @NotNull
    private Long idConductor;

    @NotNull
    private Long idRuta;
}
