package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Data
public class DetallePedidoVO {

    @NotNull(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    private BigDecimal precio;

    @NotNull(message = "La cantidad es obligatoria")
    private Integer cantidad;

    private BigDecimal peso;

    private BigDecimal volumen;

    private String ubicacion;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Long pedidoId;
}