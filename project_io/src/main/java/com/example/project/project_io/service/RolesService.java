package com.example.project.project_io.service;

import com.example.project.project_io.dtos.RolesDTO;
import com.example.project.project_io.entities.Roles;
import com.example.project.project_io.repository.RolesRepository;
import com.example.project.project_io.vo.RolesVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un rol
    public Long save(RolesVO vO) {
        Roles rol = modelMapper.map(vO, Roles.class);
        rol = rolesRepository.save(rol);
        return rol.getIdRoles();
    }

    // Método para eliminar un rol por ID
    public void delete(Long id) {
        rolesRepository.deleteById(id);
    }

    // Método para actualizar un rol
    public void update(Long id, RolesVO vO) {
        Optional<Roles> rolOptional = rolesRepository.findById(id);
        if (rolOptional.isPresent()) {
            Roles rol = rolOptional.get();
            modelMapper.map(vO, rol);
            rolesRepository.save(rol);
        } else {
            throw new IllegalArgumentException("Rol no encontrado");
        }
    }

    // Método para obtener un rol por ID
    public RolesDTO getById(Long id) {
        Optional<Roles> rolOptional = rolesRepository.findById(id);
        return rolOptional.map(rol -> modelMapper.map(rol, RolesDTO.class))
                          .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado"));
    }

    // Método para obtener todos los roles con paginación
    public Page<RolesDTO> query(Pageable pageable) {
        return rolesRepository.findAll(pageable)
                .map(rol -> modelMapper.map(rol, RolesDTO.class));
    }

    // Método para obtener un rol por nombre
    public RolesDTO findByNombre(String nombre) {
        Roles rol = rolesRepository.findByNombre(nombre);
        if (rol != null) {
            return modelMapper.map(rol, RolesDTO.class);
        } else {
            throw new IllegalArgumentException("Rol no encontrado");
        }
    }
}