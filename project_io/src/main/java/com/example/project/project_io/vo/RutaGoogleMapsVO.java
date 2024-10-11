package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Duration;

@Data
public class RutaGoogleMapsVO {

    @NotNull(message = "Las coordenadas de origen son obligatorias")
    private String coordenadasOrigen;

    @NotNull(message = "Las coordenadas de destino son obligatorias")
    private String coordenadasDestino;

    @NotNull(message = "La distancia es obligatoria")
    private BigDecimal distancia;

    @NotNull(message = "La duración es obligatoria")
    private Duration duracion;

    @NotNull(message = "El ID del vehículo es obligatorio")
    private Long idVehiculo;

    @NotNull(message = "El ID del conductor es obligatorio")
    private Long idConductor;

    @NotNull(message = "El ID de la ruta es obligatorio")
    private Long idRuta;
}