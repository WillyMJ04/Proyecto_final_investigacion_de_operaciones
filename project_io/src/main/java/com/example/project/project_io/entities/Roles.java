package com.example.project.project_io.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "roles")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idRoles;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Size(max = 100) // Limita el tamaño del campo nombre
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Size(max = 255) // Limita el tamaño de la descripción
    @Column(name = "descripcion")
    private String descripcion;
}