package com.example.project.project_io.repository;

import com.example.project.project_io.entities.RutaGoogleMaps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RutaGoogleMapsRepository extends JpaRepository<RutaGoogleMaps, Long>, JpaSpecificationExecutor<RutaGoogleMaps> {

    // Métodos personalizados si lo necesitas
}