package com.example.project.project_io.dtos;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long idCliente;

    @NotNull
    private String nombre;

    private String direccion;

    private String telefono;

    private String email;
}