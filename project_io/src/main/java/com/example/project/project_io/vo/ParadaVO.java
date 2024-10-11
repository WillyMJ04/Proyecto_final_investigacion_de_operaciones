package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

@Data
public class ParadaVO {

    @NotNull(message = "La dirección es obligatoria")
    private String direccion;

    private LocalTime horaLlegadaEstimada;

    private LocalTime horaLlegadaReal;

    @NotNull(message = "El ID de la ruta es obligatorio")
    private Long idRuta;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Long idPedido;

    @NotNull(message = "El ID del estado es obligatorio")
    private Long estadoId;

    private String coordenadasParada;
}