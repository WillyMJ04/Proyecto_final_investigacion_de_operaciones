package com.example.project.project_io.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;

@Data
@Entity
@Table(name = "ruta_google_maps")
public class RutaGoogleMaps implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idRutaGmaps;

    @Column(name = "coordenadas_origen", nullable = false)
    private String coordenadasOrigen;

    @Column(name = "coordenadas_destino", nullable = false)
    private String coordenadasDestino;

    @Column(name = "distancia", nullable = false)
    private BigDecimal distancia;

    @Column(name = "duracion", nullable = false)
    private float duracion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id", nullable = false)
    private Vehiculo vehiculo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conductor", referencedColumnName = "id", nullable = false)
    private Conductor conductor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ruta", referencedColumnName = "id", nullable = false)
    private Ruta ruta;
}