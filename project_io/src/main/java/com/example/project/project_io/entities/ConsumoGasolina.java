package com.example.project.project_io.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "consumo_gasolina")
public class ConsumoGasolina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consumo_gasolina", nullable = false)
    private Long id;

    @NotNull // Validación para asegurar que no sea nulo
    @Min(value = 0, message = "La cantidad consumida debe ser mayor o igual a 0") // Validación para evitar valores negativos
    @Column(name = "cantidad_consumida", nullable = false)
    private Double cantidadConsumida;


}