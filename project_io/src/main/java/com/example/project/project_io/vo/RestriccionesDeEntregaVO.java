package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class RestriccionesDeEntregaVO {

    @NotNull(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long idCliente;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Long idPedido;
}