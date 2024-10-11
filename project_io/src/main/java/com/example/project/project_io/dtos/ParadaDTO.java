package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalTime;

@Data
public class ParadaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idParada;

    @NotNull
    private String direccion;

    private LocalTime horaLlegadaEstimada;

    private LocalTime horaLlegadaReal;

    @NotNull
    private Long idRuta;

    @NotNull
    private Long idPedido;

    @NotNull
    private Long estadoId;

    private String coordenadasParada;
}