package com.example.project.project_io.repository;

import com.example.project.project_io.entities.RestriccionesVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RestriccionesVehiculoRepository extends JpaRepository<RestriccionesVehiculo, Long>, JpaSpecificationExecutor<RestriccionesVehiculo> {

    // Métodos personalizados si los necesitas
}