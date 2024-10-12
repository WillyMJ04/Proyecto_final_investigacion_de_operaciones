package com.example.project.project_io.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    private Long id;

    @NotNull // Asegura que no sea nulo
    @Column(name = "fecha_ruta", nullable = false)
    private LocalDate fechaRuta;

    @NotNull // Asegura que no sea nulo
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @Min(value = 0, message = "El kilometraje debe ser mayor o igual a 0") // Evita valores negativos
    @Column(name = "kilometraje_recorrido")
    private Double kilometrajeRecorrido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conductor", referencedColumnName = "id", nullable = false)
    private Conductor conductor;

    @Column(name = "coordenadas_inicio")
    private String coordenadasInicio;

    @Column(name = "coordenadas_fin")
    private String coordenadasFin;

    @Positive(message = "La distancia debe ser mayor que 0") // Asegura que la distancia sea positiva
    @Column(name = "distancia")
    private Double distancia;

    @Column(name = "tiempo_estimado")
    private LocalTime tiempoEstimado;
}