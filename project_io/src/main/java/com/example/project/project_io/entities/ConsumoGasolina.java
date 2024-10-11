package com.example.project.project_io.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "consumo_gasolina")
public class ConsumoGasolina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tipo_gasolina", nullable = false)
    private String tipoGasolina;

    @Column(name = "precio_por_litro", nullable = false)
    private BigDecimal precioPorLitro;

    @Column(name = "litros_consumidos", nullable = false)
    private BigDecimal litrosConsumidos;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id", nullable = false)
    private Vehiculo vehiculo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ruta", referencedColumnName = "id", nullable = false)
    private Ruta ruta;
}