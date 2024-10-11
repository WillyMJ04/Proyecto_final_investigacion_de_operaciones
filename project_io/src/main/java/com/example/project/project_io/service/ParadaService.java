package com.example.project.project_io.service;

import com.example.project.project_io.dtos.ParadaDTO;
import com.example.project.project_io.entities.Parada;
import com.example.project.project_io.repository.ParadaRepository;
import com.example.project.project_io.vo.ParadaVO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParadaService {

    @Autowired
    private ParadaRepository paradaRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar una parada
    public Long save(@Valid ParadaVO vO) {
        Parada parada = modelMapper.map(vO, Parada.class);
        parada = paradaRepository.save(parada);
        return parada.getIdParada();
    }

    // Método para eliminar una parada por ID
    public void delete(Long id) {
        paradaRepository.deleteById(id);
    }

    // Método para actualizar una parada
    public void update(Long id, ParadaVO vO) {
        Optional<Parada> paradaOptional = paradaRepository.findById(id);
        if (paradaOptional.isPresent()) {
            Parada parada = paradaOptional.get();
            modelMapper.map(vO, parada);
            paradaRepository.save(parada);
        } else {
            throw new IllegalArgumentException("Parada no encontrada");
        }
    }

    // Método para obtener una parada por ID
    public ParadaDTO getById(Long id) {
        Optional<Parada> paradaOptional = paradaRepository.findById(id);
        return paradaOptional.map(parada -> modelMapper.map(parada, ParadaDTO.class))
                             .orElseThrow(() -> new IllegalArgumentException("Parada no encontrada"));
    }

    // Método para obtener todas las paradas con paginación
    public Page<ParadaDTO> query(Pageable pageable) {
        return paradaRepository.findAll(pageable)
                .map(parada -> modelMapper.map(parada, ParadaDTO.class));
    }
}