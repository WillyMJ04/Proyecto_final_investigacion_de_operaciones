package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalTime;

@Data
public class HorarioDisponibilidadDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idHorario;

    @NotNull
    private String diaSemana;

    @NotNull
    private LocalTime horaInicio;

    @NotNull
    private LocalTime horaFin;

    @NotNull
    private Long idCliente;
}