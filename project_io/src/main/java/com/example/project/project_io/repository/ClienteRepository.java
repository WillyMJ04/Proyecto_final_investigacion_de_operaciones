package com.example.project.project_io.repository;

import com.example.project.project_io.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

    // Aquí podrías agregar métodos personalizados si lo necesitas, por ejemplo:
    Cliente findByEmail(String email);
}