package com.example.project.project_io.service;

import com.example.project.project_io.dtos.EstadosDTO;
import com.example.project.project_io.vo.EstadosVO;
import com.example.project.project_io.entities.Estados;
import com.example.project.project_io.repository.EstadosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadosService {

    @Autowired
    private EstadosRepository estadosRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un estado
    public Long save(EstadosVO vO) {
        Estados estado = modelMapper.map(vO, Estados.class);
        estado = estadosRepository.save(estado);
        return estado.getId();
    }

    // Método para eliminar un estado por ID
    public void delete(Long id) {
        estadosRepository.deleteById(id);
    }

    // Método para actualizar un estado
    public void update(Long id, EstadosVO vO) {
        Optional<Estados> estadoOptional = estadosRepository.findById(id);
        if (estadoOptional.isPresent()) {
            Estados estado = estadoOptional.get();
            modelMapper.map(vO, estado);
            estadosRepository.save(estado);
        } else {
            throw new IllegalArgumentException("Estado no encontrado");
        }
    }

    // Método para obtener un estado por ID
    public EstadosDTO getById(Long id) {
        Optional<Estados> estadoOptional = estadosRepository.findById(id);
        return estadoOptional.map(estado -> modelMapper.map(estado, EstadosDTO.class))
                             .orElseThrow(() -> new IllegalArgumentException("Estado no encontrado"));
    }

    // Método para obtener todos los estados con paginación
    public Page<EstadosDTO> query(Pageable pageable) {
        return estadosRepository.findAll(pageable)
                .map(estado -> modelMapper.map(estado, EstadosDTO.class));
    }

    // Método para obtener un estado por nombre
    public EstadosDTO findByNombre(String nombre) {
        Estados estado = estadosRepository.findByNombre(nombre);
        if (estado != null) {
            return modelMapper.map(estado, EstadosDTO.class);
        } else {
            throw new IllegalArgumentException("Estado no encontrado");
        }
    }
}