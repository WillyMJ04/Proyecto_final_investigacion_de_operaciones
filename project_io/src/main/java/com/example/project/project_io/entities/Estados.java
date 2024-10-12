package com.example.project.project_io.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "estados", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Estados implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Size(max = 100) // Limita el tamaño máximo del nombre
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Size(max = 255) // Limita el tamaño de la descripción
    @Column(name = "descripcion")
    private String descripcion;
}