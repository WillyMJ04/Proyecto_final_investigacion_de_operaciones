package com.example.project.project_io.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ruta_google_maps")
public class RutaGoogleMaps implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta_gmaps", nullable = false)
    private Long idRutaGmaps;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Column(name = "coordenadas_origen", nullable = false)
    private String coordenadasOrigen;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Column(name = "coordenadas_destino", nullable = false)
    private String coordenadasDestino;

    @NotNull // Asegura que no sea nulo
    @Positive(message = "La distancia debe ser mayor que 0") // Asegura que sea positiva
    @Column(name = "distancia", nullable = false)
    private BigDecimal distancia; // Cambiado a BigDecimal para mayor precisión

    @NotNull // Asegura que no sea nulo
    @Positive(message = "La duración debe ser mayor que 0") // Asegura que sea positiva
    @Column(name = "duracion", nullable = false)
    private BigDecimal duracion; // Cambiado a BigDecimal para mayor precisión

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conductor", referencedColumnName = "id", nullable = false)
    private Conductor conductor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ruta", referencedColumnName = "id", nullable = false)
    private Ruta ruta;
}