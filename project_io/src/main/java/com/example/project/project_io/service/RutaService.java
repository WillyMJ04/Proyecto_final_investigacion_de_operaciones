package com.example.project.project_io.service;

import com.example.project.project_io.dtos.RutaDTO;
import com.example.project.project_io.entities.Ruta;
import com.example.project.project_io.repository.RutaRepository;
import com.example.project.project_io.vo.RutaVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar una ruta
    public Long save(RutaVO vO) {
        Ruta ruta = modelMapper.map(vO, Ruta.class);
        ruta = rutaRepository.save(ruta);
        return ruta.getIdRuta();
    }

    // Método para eliminar una ruta por ID
    public void delete(Long id) {
        rutaRepository.deleteById(id);
    }

    // Método para actualizar una ruta
    public void update(Long id, RutaVO vO) {
        Optional<Ruta> rutaOptional = rutaRepository.findById(id);
        if (rutaOptional.isPresent()) {
            Ruta ruta = rutaOptional.get();
            modelMapper.map(vO, ruta);
            rutaRepository.save(ruta);
        } else {
            throw new IllegalArgumentException("Ruta no encontrada");
        }
    }

    // Método para obtener una ruta por ID
    public RutaDTO getById(Long id) {
        Optional<Ruta> rutaOptional = rutaRepository.findById(id);
        return rutaOptional.map(ruta -> modelMapper.map(ruta, RutaDTO.class))
                           .orElseThrow(() -> new IllegalArgumentException("Ruta no encontrada"));
    }

    // Método para obtener todas las rutas con paginación
    public Page<RutaDTO> query(Pageable pageable) {
        return rutaRepository.findAll(pageable)
                .map(ruta -> modelMapper.map(ruta, RutaDTO.class));
    }
}