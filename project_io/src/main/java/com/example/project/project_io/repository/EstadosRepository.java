package com.example.project.project_io.repository;

import com.example.project.project_io.entities.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstadosRepository extends JpaRepository<Estados, Long>, JpaSpecificationExecutor<Estados> {

    // Método personalizado si es necesario
    Estados findByNombre(String nombre);
}