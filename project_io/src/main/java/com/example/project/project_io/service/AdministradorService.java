package com.example.project.project_io.service;

import com.example.project.project_io.dtos.AdministradorDTO;
import com.example.project.project_io.entities.Administrador;
import com.example.project.project_io.repository.AdministradorRepository;
import com.example.project.project_io.vo.AdministradorVO;
import com.example.project.project_io.vo.AdministradorUpdateVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public void update(Long id, AdministradorUpdateVO vO) {
        Optional<Administrador> administradorOptional = administradorRepository.findById(id);
        if (administradorOptional.isPresent()) {
            Administrador administrador = administradorOptional.get();
            modelMapper.map(vO, administrador);
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

    // Método para obtener todos los administradores sin paginación
    public List<AdministradorDTO> getAllAdministradores() {
        return administradorRepository.findAll()
                .stream()
                .map(administrador -> modelMapper.map(administrador, AdministradorDTO.class))
                .collect(Collectors.toList());
    }
}