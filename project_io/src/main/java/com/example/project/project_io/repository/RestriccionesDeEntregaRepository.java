package com.example.project.project_io.repository;

import com.example.project.project_io.entities.RestriccionesDeEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RestriccionesDeEntregaRepository extends JpaRepository<RestriccionesDeEntrega, Long>, JpaSpecificationExecutor<RestriccionesDeEntrega> {

    // Métodos personalizados si lo necesitas
}