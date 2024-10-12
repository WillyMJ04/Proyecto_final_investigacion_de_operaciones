package com.example.project.project_io.vo;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data

public class ProveedorProductoVO {
    @NotNull(message = "El ID del proveedor es obligatorio")
    private Long idProveedor;

    @NotNull(message = "El ID del producto es obligatorio")
    private Long idProducto;

    @NotNull(message = "El precio del producto es obligatorio")
    private BigDecimal precioProducto;

    @NotNull(message = "La existencia es obligatoria")
    private int existencia;
}
