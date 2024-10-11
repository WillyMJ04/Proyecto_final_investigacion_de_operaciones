package com.example.project.project_io.repository;

import com.example.project.project_io.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long>, JpaSpecificationExecutor<DetallePedido> {

    // Métodos personalizados si lo necesitas
}