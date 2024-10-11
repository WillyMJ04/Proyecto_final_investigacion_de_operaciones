package com.example.project.project_io.repository;

import com.example.project.project_io.entities.HorarioDisponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HorarioDisponibilidadRepository extends JpaRepository<HorarioDisponibilidad, Long>, JpaSpecificationExecutor<HorarioDisponibilidad> {

    // Métodos personalizados si lo necesitas
}