package com.example.project.project_io.repository;

import com.example.project.project_io.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

    // Método para buscar un usuario por correo electrónico
    Usuario findByEmail(String email);
}