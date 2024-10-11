package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class ConductorPedidoVO {

    @NotNull(message = "El ID del conductor es obligatorio")
    private Long idConductor;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Long idPedido;
}