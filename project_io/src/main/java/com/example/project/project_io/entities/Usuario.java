package com.example.project.project_io.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idUsuario;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Size(max = 100) // Limita el tamaño del nombre
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Email // Valida que tenga un formato de email correcto
    @Size(max = 100) // Limita el tamaño del email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres") // Limita el tamaño de la contraseña
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id", referencedColumnName = "id", nullable = false)
    private Roles rol;
}