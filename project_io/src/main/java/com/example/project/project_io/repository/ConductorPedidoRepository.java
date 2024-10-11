package com.example.project.project_io.repository;

import com.example.project.project_io.entities.ConductorPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConductorPedidoRepository extends JpaRepository<ConductorPedido, Long>, JpaSpecificationExecutor<ConductorPedido> {

    // Consulta basada en el campo "id" tanto para Conductor como para Pedido
    ConductorPedido findByConductor_IdAndId(Long idConductor, Long idPedido);
}