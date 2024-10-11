package com.example.project.project_io.repository;

import com.example.project.project_io.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>, JpaSpecificationExecutor<Administrador> {
    // Métodos personalizados si los necesitas
}