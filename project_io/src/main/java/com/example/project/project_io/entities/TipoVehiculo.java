package com.example.project.project_io.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tipo_vehiculo")
public class TipoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idTipoVehiculo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "consumo_por_km", nullable = false)
    private BigDecimal consumoPorKm;
}
