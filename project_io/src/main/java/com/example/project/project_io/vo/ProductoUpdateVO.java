package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductoUpdateVO {
    @NotNull(message = "El nombre del producto es obligatorio")
    private String nombreProducto;

    @NotNull(message = "El tipo del producto es obligatorio")
    private String tipoProducto;

    @NotNull(message = "El peso del producto es obligatorio")
    private BigDecimal pesoProducto;

    @NotNull(message = "El estado del producto es obligatorio")
    private int estado;
}