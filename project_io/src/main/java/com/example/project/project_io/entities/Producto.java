package com.example.project.project_io.entities;

import jakarta.persistence.*;
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
    @Column(name = "id_producto", nullable = false)
    private Long idProducto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "tipo_producto", nullable = false)
    private String tipoProducto;

    @Column(name = "peso_producto", nullable = false)
    private BigDecimal pesoProducto;

    @Column(name = "estado", nullable = false)
    private int estado;
}