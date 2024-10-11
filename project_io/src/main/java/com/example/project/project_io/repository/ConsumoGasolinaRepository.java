package com.example.project.project_io.repository;

import com.example.project.project_io.entities.ConsumoGasolina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConsumoGasolinaRepository extends JpaRepository<ConsumoGasolina, Long>, JpaSpecificationExecutor<ConsumoGasolina> {

    // Método personalizado si lo necesitas
}