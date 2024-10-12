package com.example.project.project_io.dtos;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductoDTO {
    private Long idProducto;
    private String nombreProducto;
    private String tipoProducto;
    private BigDecimal pesoProducto;
    private int estado;
}