package com.example.project.project_io.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detallePedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Pedido pedido;


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Producto product;

    int cantidad;

    float precio;

    float total;
}
