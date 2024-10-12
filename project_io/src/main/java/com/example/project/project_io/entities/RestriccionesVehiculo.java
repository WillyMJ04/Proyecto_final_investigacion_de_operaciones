package com.example.project.project_io.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "restricciones_vehiculo")
public class RestriccionesVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Column(name = "restriccion_paradas")
    private String restriccionParadas;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Column(name = "restriccion_visitas")
    private String restriccionVisitas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id", nullable = false) // Asegura que la relación no sea nula
    private Vehiculo vehiculo;
}