package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

@Data
public class HorarioDisponibilidadVO {

    @NotNull(message = "El día de la semana es obligatorio")
    private String diaSemana;

    @NotNull(message = "La hora de inicio es obligatoria")
    private LocalTime horaInicio;

    @NotNull(message = "La hora de fin es obligatoria")
    private LocalTime horaFin;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long idCliente;
}