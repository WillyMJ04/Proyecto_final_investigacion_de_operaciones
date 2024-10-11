package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DetallePedidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    private String descripcion;

    @NotNull
    private BigDecimal precio;

    @NotNull
    private Integer cantidad;

    private BigDecimal peso;

    private BigDecimal volumen;

    private String ubicacion;

    @NotNull
    private Long pedidoId;
}