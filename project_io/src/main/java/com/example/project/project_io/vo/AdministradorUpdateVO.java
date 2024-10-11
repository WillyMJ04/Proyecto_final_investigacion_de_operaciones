package com.example.project.project_io.vo;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class AdministradorUpdateVO {

    @NotNull(message = "El ID del usuario es obligatorio")
    private Long idUsuario;

    // Otros campos que puedan ser necesarios para la actualización
}