package com.example.project.project_io.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor", nullable = false)
    private Long idProveedor;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Column(name = "direccion_proveedor")
    private String direccionProveedor;

    @Column(name = "longitud")
    private String longitud;

    @Column(name = "latitud")
    private String latitud;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "usuario_creo")
    private String usuarioCreo;

    @Column(name = "fecha_creo")
    private LocalDateTime fechaCreo;

    @Column(name = "usuario_modifico")
    private String usuarioModifico;

    @Column(name = "fecha_modifico")
    private LocalDateTime fechaModifico;
}