package com.example.project.project_io.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Column(name = "tipo_producto", nullable = false)
    private String tipoProducto;

    @NotNull // Asegura que el peso no sea nulo
    @Min(value = 0, message = "El peso del producto debe ser mayor o igual a 0") // Evita valores negativos
    @Column(name = "peso_producto", nullable = false)
    private BigDecimal pesoProducto;

    @Column(name = "estado", nullable = false)
    private int estado;  // Considera usar un Enum si los estados son fijos
}