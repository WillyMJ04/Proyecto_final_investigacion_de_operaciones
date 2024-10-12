package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ProveedorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idProveedor;

    private String nombreProveedor;
    private String direccionProveedor;
    private String longitud;
    private String latitud;
    private Integer estado;
}