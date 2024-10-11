package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PedidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idPedido;

    @NotNull
    private LocalDate fechaPedido;

    @NotNull
    private LocalDate fechaEntregaDeseada;

    @NotNull
    private Long estadoId;

    @NotNull
    private Long clienteId;
}
