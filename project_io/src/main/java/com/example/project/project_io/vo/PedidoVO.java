package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
public class PedidoVO {

    @NotNull(message = "La fecha del pedido es obligatoria")
    private LocalDate fechaPedido;

    @NotNull(message = "La fecha de entrega deseada es obligatoria")
    private LocalDate fechaEntregaDeseada;

    @NotNull(message = "El ID del estado es obligatorio")
    private Long estadoId;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;
}