package com.example.project.project_io.service;

import com.example.project.project_io.dtos.AdministradorDTO;
import com.example.project.project_io.vo.AdministradorUpdateVO;
import com.example.project.project_io.vo.AdministradorVO;
import com.example.project.project_io.entities.Administrador;
import com.example.project.project_io.repository.AdministradorRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un administrador
    public Long save(AdministradorVO vO) {
        Administrador administrador = modelMapper.map(vO, Administrador.class);
        administrador = administradorRepository.save(administrador);
        return administrador.getId();
    }

    // Método para eliminar un administrador por ID
    public void delete(Long id) {
        administradorRepository.deleteById(id);
    }

    // Método para actualizar un administrador
    public void update(Long id, @Valid AdministradorUpdateVO vO) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(id);
        if (administradorOptional.isPresent()) {
            Administrador administrador = administradorOptional.get();
            modelMapper.map(vO, administrador);  // Actualiza los campos del administrador con los datos del VO
            administradorRepository.save(administrador);
        } else {
            throw new IllegalArgumentException("Administrador no encontrado");
        }
    }

    // Método para obtener un administrador por ID
    public AdministradorDTO getById(Long id) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(id);
        return administradorOptional.map(administrador -> modelMapper.map(administrador, AdministradorDTO.class))
                                    .orElseThrow(() -> new IllegalArgumentException("Administrador no encontrado"));
    }

    // Método para obtener todos los administradores con paginación
    public Page<AdministradorDTO> query(Pageable pageable) {
        return administradorRepository.findAll(pageable)
                .map(administrador -> modelMapper.map(administrador, AdministradorDTO.class));
    }
}