package com.example.project.project_io.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_licencia")
public class TipoLicencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_licencia", nullable = false)
    private Long idTipoLicencia;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
}