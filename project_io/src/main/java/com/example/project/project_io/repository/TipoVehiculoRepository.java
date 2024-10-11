package com.example.project.project_io.repository;

import com.example.project.project_io.entities.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Long>, JpaSpecificationExecutor<TipoVehiculo> {

    // Métodos personalizados si lo necesitas
}