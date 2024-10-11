package com.example.project.project_io.repository;

import com.example.project.project_io.entities.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConductorRepository extends JpaRepository<Conductor, Long>, JpaSpecificationExecutor<Conductor> {

    // Método para encontrar un conductor por su número de documento
    Conductor findByNumeroDocumento(String numeroDocumento);
}
