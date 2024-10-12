package com.example.project.project_io.repository;

import com.example.project.project_io.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Buscar por nombre
    Cliente findByNombre(String nombre);

    // Buscar por email
    Cliente findByEmail(String email);
}