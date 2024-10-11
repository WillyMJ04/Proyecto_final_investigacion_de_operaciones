package com.example.project.project_io.repository;

import com.example.project.project_io.entities.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RutaRepository extends JpaRepository<Ruta, Long>, JpaSpecificationExecutor<Ruta> {

    // Métodos personalizados si lo necesitas
}