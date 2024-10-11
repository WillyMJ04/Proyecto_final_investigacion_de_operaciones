package com.example.project.project_io.service;

import com.example.project.project_io.dtos.RolesDTO;
import com.example.project.project_io.dtos.UsuarioDTO;
import com.example.project.project_io.entities.Roles;
import com.example.project.project_io.repository.RolesRepository;
import com.example.project.project_io.vo.UsuarioVO;
import com.example.project.project_io.entities.Usuario;
import com.example.project.project_io.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RolesRepository rolesRepository;
    // Método para guardar un usuario
    public Usuario save(UsuarioVO vO) {
        Usuario usuario = modelMapper.map(vO, Usuario.class);
        Roles rol= rolesRepository.getById(vO.getRolId());
        if(rol==null)
            return null;
        usuario.setRol(rol);
        usuario = usuarioRepository.save(usuario);
        return usuario;
    }

    // Método para eliminar un usuario por ID
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para actualizar un usuario
    public void update(Long id, UsuarioVO vO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            modelMapper.map(vO, usuario);
            usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
    }

    // Método para obtener un usuario por ID
    public UsuarioDTO getById(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                              .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }

    // Método para obtener todos los usuarios con paginación
    public Page<UsuarioDTO> query(Pageable pageable) {
        return usuarioRepository.findAll(pageable)
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class));
    }

    // Método para obtener un usuario por correo electrónico
    public UsuarioDTO findByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null) {
            return modelMapper.map(usuario, UsuarioDTO.class);
        } else {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
    }
}
