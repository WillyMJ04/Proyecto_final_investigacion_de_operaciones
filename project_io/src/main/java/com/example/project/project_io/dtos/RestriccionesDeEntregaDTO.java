package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Data
public class RestriccionesDeEntregaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idRestriccion;

    @NotNull
    private String descripcion;

    @NotNull
    private Long idCliente;

    @NotNull
    private Long idPedido;
}