package com.example.project.project_io.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_vehiculo")
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_vehiculo", nullable = false)
    private Long idTipoVehiculo;

    @Column(name = "nombre", nullable = false)
    private String nombre;
}