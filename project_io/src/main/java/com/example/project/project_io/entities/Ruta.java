package com.example.project.project_io.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "rutas")
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idRuta;

    @Column(name = "fecha_ruta", nullable = false)
    private LocalDate fechaRuta;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @Column(name = "kilometraje_recorrido")
    private BigDecimal kilometrajeRecorrido;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conductor", referencedColumnName = "id", nullable = false)
    private Conductor conductor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id", nullable = false)
    private Vehiculo vehiculo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
    private Estados estado;

    @Column(name = "coordenadas_inicio")
    private String coordenadasInicio;

    @Column(name = "coordenadas_fin")
    private String coordenadasFin;

    @Column(name = "distancia")
    private BigDecimal distancia;

    @Column(name = "tiempo_estimado")
    private LocalTime tiempoEstimado;
}
