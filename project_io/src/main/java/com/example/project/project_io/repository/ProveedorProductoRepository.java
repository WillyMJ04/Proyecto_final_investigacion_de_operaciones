package com.example.project.project_io.repository;

import com.example.project.project_io.entities.ProveedorProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProveedorProductoRepository extends JpaRepository<ProveedorProducto, Long>, JpaSpecificationExecutor<ProveedorProducto>{
}
