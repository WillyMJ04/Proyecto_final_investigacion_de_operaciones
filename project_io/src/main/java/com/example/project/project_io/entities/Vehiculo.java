package com.example.project.project_io.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idVehiculo;

    @Column(name = "capacidad_de_carga", nullable = false)
    private BigDecimal capacidadDeCarga;

    @Column(name = "capacidad_volumen", nullable = false)
    private BigDecimal capacidadVolumen;

    @Column(name = "licencia", nullable = false)
    private String licencia;

    @Column(name = "disponibilidad_horaria")
    private String disponibilidadHoraria;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_vehiculo_id", referencedColumnName = "id", nullable = false)
    private TipoVehiculo tipoVehiculo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_licencia_id", referencedColumnName = "id", nullable = false)
    private TipoLicencia tipoLicencia;
}
