package com.example.project.project_io.repository;

import com.example.project.project_io.entities.TipoLicencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoLicenciaRepository extends JpaRepository<TipoLicencia, Long>, JpaSpecificationExecutor<TipoLicencia> {

    // Métodos personalizados si lo necesitas
}