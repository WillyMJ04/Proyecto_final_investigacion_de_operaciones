package com.example.project.project_io.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "parada", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "id_pedido"})})
public class Parada implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id", nullable = false)
    private Pedido pedido;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Size(max = 255) // Limita el tamaño de la dirección
    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "hora_llegada_estimada")
    private Timestamp horaLlegadaEstimada;

    @Column(name = "hora_llegada_real")
    private Timestamp horaLlegadaReal;

    @Size(max = 100) // Limita el tamaño de las coordenadas
    @Column(name = "coordenadas_parada")
    private String coordenadasParada;

}