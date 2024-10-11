package com.example.project.project_io.service;

import com.example.project.project_io.dtos.RestriccionesDeEntregaDTO;
import com.example.project.project_io.entities.RestriccionesDeEntrega;
import com.example.project.project_io.repository.RestriccionesDeEntregaRepository;
import com.example.project.project_io.vo.RestriccionesDeEntregaVO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestriccionesDeEntregaService {

    @Autowired
    private RestriccionesDeEntregaRepository restriccionesDeEntregaRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar una restricción de entrega
    public Long save(RestriccionesDeEntregaVO vO) {
        RestriccionesDeEntrega restriccion = modelMapper.map(vO, RestriccionesDeEntrega.class);
        restriccion = restriccionesDeEntregaRepository.save(restriccion);
        return restriccion.getIdRestriccion();
    }

    // Método para eliminar una restricción de entrega por ID
    public void delete(Long id) {
        restriccionesDeEntregaRepository.deleteById(id);
    }

    // Método para actualizar una restricción de entrega
    public void update(Long id, @Valid RestriccionesDeEntregaVO vO) {
        Optional<RestriccionesDeEntrega> restriccionOptional = restriccionesDeEntregaRepository.findById(id);
        if (restriccionOptional.isPresent()) {
            RestriccionesDeEntrega restriccion = restriccionOptional.get();
            modelMapper.map(vO, restriccion);
            restriccionesDeEntregaRepository.save(restriccion);
        } else {
            throw new IllegalArgumentException("Restricción de entrega no encontrada");
        }
    }

    // Método para obtener una restricción de entrega por ID
    public RestriccionesDeEntregaDTO getById(Long id) {
        Optional<RestriccionesDeEntrega> restriccionOptional = restriccionesDeEntregaRepository.findById(id);
        return restriccionOptional.map(restriccion -> modelMapper.map(restriccion, RestriccionesDeEntregaDTO.class))
                                  .orElseThrow(() -> new IllegalArgumentException("Restricción de entrega no encontrada"));
    }

    // Método para obtener todas las restricciones de entrega con paginación
    public Page<RestriccionesDeEntregaDTO> query(Pageable pageable) {
        return restriccionesDeEntregaRepository.findAll(pageable)
                .map(restriccion -> modelMapper.map(restriccion, RestriccionesDeEntregaDTO.class));
    }
}