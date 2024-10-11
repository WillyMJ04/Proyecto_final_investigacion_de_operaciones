package com.example.project.project_io.service;

import com.example.project.project_io.dtos.ConductorDTO;
import com.example.project.project_io.vo.ConductorVO;
import com.example.project.project_io.entities.Conductor;
import com.example.project.project_io.repository.ConductorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un conductor
    public Long save(ConductorVO vO) {
        Conductor conductor = modelMapper.map(vO, Conductor.class);
        conductor = conductorRepository.save(conductor);
        return conductor.getId();
    }

    // Método para eliminar un conductor por ID
    public void delete(Long id) {
        conductorRepository.deleteById(id);
    }

    // Método para actualizar un conductor
    public void update(Long id, ConductorVO vO) {
        Optional<Conductor> conductorOptional = conductorRepository.findById(id);
        if (conductorOptional.isPresent()) {
            Conductor conductor = conductorOptional.get();
            modelMapper.map(vO, conductor);
            conductorRepository.save(conductor);
        } else {
            throw new IllegalArgumentException("Conductor no encontrado");
        }
    }

    // Método para obtener un conductor por ID
    public ConductorDTO getById(Long id) {
        Optional<Conductor> conductorOptional = conductorRepository.findById(id);
        return conductorOptional.map(conductor -> modelMapper.map(conductor, ConductorDTO.class))
                                .orElseThrow(() -> new IllegalArgumentException("Conductor no encontrado"));
    }

    // Método para obtener todos los conductores con paginación
    public Page<ConductorDTO> query(Pageable pageable) {
        return conductorRepository.findAll(pageable)
                .map(conductor -> modelMapper.map(conductor, ConductorDTO.class));
    }

    // Método para obtener un conductor por su número de documento
    public ConductorDTO findByNumeroDocumento(String numeroDocumento) {
        Conductor conductor = conductorRepository.findByNumeroDocumento(numeroDocumento);
        if (conductor != null) {
            return modelMapper.map(conductor, ConductorDTO.class);
        } else {
            throw new IllegalArgumentException("Conductor no encontrado");
        }
    }
}