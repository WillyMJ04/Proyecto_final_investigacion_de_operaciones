package com.example.project.project_io.dtos;

import lombok.Data;
import java.math.BigDecimal;

@Data

public class ProveedorProductoDTO {
    private Long id;
    private Long idProveedor;
    private Long idProducto;
    private BigDecimal precioProducto;
    private int existencia;
}
