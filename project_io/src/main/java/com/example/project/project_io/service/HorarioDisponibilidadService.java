package com.example.project.project_io.service;

import com.example.project.project_io.dtos.HorarioDisponibilidadDTO;
import com.example.project.project_io.entities.HorarioDisponibilidad;
import com.example.project.project_io.repository.HorarioDisponibilidadRepository;
import com.example.project.project_io.vo.HorarioDisponibilidadVO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HorarioDisponibilidadService {

    @Autowired
    private HorarioDisponibilidadRepository horarioDisponibilidadRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un horario de disponibilidad
    public Long save(@Valid HorarioDisponibilidadVO vO) {
        HorarioDisponibilidad horarioDisponibilidad = modelMapper.map(vO, HorarioDisponibilidad.class);
        horarioDisponibilidad = horarioDisponibilidadRepository.save(horarioDisponibilidad);
        return horarioDisponibilidad.getIdHorario();
    }

    // Método para eliminar un horario de disponibilidad por ID
    public void delete(Long id) {
        horarioDisponibilidadRepository.deleteById(id);
    }

    // Método para actualizar un horario de disponibilidad
    public void update(Long id, HorarioDisponibilidadVO vO) {
        Optional<HorarioDisponibilidad> horarioDisponibilidadOptional = horarioDisponibilidadRepository.findById(id);
        if (horarioDisponibilidadOptional.isPresent()) {
            HorarioDisponibilidad horarioDisponibilidad = horarioDisponibilidadOptional.get();
            modelMapper.map(vO, horarioDisponibilidad);
            horarioDisponibilidadRepository.save(horarioDisponibilidad);
        } else {
            throw new IllegalArgumentException("Horario de disponibilidad no encontrado");
        }
    }

    // Método para obtener un horario de disponibilidad por ID
    public HorarioDisponibilidadDTO getById(Long id) {
        Optional<HorarioDisponibilidad> horarioDisponibilidadOptional = horarioDisponibilidadRepository.findById(id);
        return horarioDisponibilidadOptional.map(horarioDisponibilidad -> modelMapper.map(horarioDisponibilidad, HorarioDisponibilidadDTO.class))
                                            .orElseThrow(() -> new IllegalArgumentException("Horario de disponibilidad no encontrado"));
    }

    // Método para obtener todos los horarios con paginación
    public Page<HorarioDisponibilidadDTO> query(Pageable pageable) {
        return horarioDisponibilidadRepository.findAll(pageable)
                .map(horarioDisponibilidad -> modelMapper.map(horarioDisponibilidad, HorarioDisponibilidadDTO.class));
    }
}