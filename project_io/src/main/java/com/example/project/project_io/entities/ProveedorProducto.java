package com.example.project.project_io.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "proveedor_producto")
public class ProveedorProducto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id", nullable = false)
    private Proveedor proveedor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "id", nullable = false)
    private Producto producto;

    @NotNull // Asegura que no sea nulo
    @Positive(message = "El precio del producto debe ser mayor que 0") // Asegura que sea un valor positivo
    @Column(name = "precio_producto", nullable = false)
    private BigDecimal precioProducto; // Cambiado a BigDecimal para mayor precisión

    @NotNull // Asegura que no sea nulo
    @Min(value = 0, message = "La existencia debe ser mayor o igual a 0") // Evita cantidades negativas
    @Column(name = "existencia", nullable = false)
    private Integer existencia;

    @NotNull // Asegura que no sea nulo
    @Column(name = "estado", nullable = false)
    private Integer estado;
}