package com.example.project.project_io.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idProveedor;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Column(name = "nombre_proveedor", nullable = false)
    private String nombreProveedor;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Column(name = "direccion_proveedor")
    private String direccionProveedor;

    @Column(name = "longitud")
    private String longitud;  // Cambiado a BigDecimal para representar coordenadas correctamente

    @Column(name = "latitud")
    private String latitud;   // Cambiado a BigDecimal para representar coordenadas correctamente

    @NotNull // Asegura que el estado no sea nulo
    @Column(name = "estado", nullable = false)
    private Integer estado;

    @NotBlank // Asegura que no sea nulo ni vacío
    @Column(name = "usuario_creo", nullable = false)
    private String usuarioCreo;

    @NotNull // Asegura que la fecha de creación no sea nula
    @Column(name = "fecha_creo", nullable = false)
    private LocalDateTime fechaCreo;

    @Column(name = "usuario_modifico")
    private String usuarioModifico;

    @Column(name = "fecha_modifico")
    private LocalDateTime fechaModifico;
}