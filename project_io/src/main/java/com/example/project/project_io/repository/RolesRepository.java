package com.example.project.project_io.repository;

import com.example.project.project_io.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RolesRepository extends JpaRepository<Roles, Long>, JpaSpecificationExecutor<Roles> {

    // Método para encontrar un rol por su nombre
    Roles findByNombre(String nombre);
}