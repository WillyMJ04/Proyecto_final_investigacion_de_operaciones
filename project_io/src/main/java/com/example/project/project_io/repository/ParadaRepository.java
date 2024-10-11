package com.example.project.project_io.repository;

import com.example.project.project_io.entities.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ParadaRepository extends JpaRepository<Parada, Long>, JpaSpecificationExecutor<Parada> {

    // Métodos personalizados si lo necesitas
}