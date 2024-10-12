package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class ProveedorVO {
    @NotNull
    private String nombreProveedor;
    private String direccionProveedor;
    private String longitud;
    private String latitud;
    private Integer estado;
}