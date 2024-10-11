package com.example.project.project_io.service;

import com.example.project.project_io.dtos.RestriccionesVehiculoDTO;
import com.example.project.project_io.entities.RestriccionesVehiculo;
import com.example.project.project_io.repository.RestriccionesVehiculoRepository;
import com.example.project.project_io.vo.RestriccionesVehiculoVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestriccionesVehiculoService {

    @Autowired
    private RestriccionesVehiculoRepository restriccionesVehiculoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar una restricción de vehículo
    public Long save(RestriccionesVehiculoVO vO) {
        RestriccionesVehiculo restriccion = modelMapper.map(vO, RestriccionesVehiculo.class);
        restriccion = restriccionesVehiculoRepository.save(restriccion);
        return restriccion.getId();
    }

    // Método para eliminar una restricción de vehículo por ID
    public void delete(Long id) {
        restriccionesVehiculoRepository.deleteById(id);
    }

    // Método para actualizar una restricción de vehículo
    public void update(Long id, RestriccionesVehiculoVO vO) {
        Optional<RestriccionesVehiculo> restriccionOptional = restriccionesVehiculoRepository.findById(id);
        if (restriccionOptional.isPresent()) {
            RestriccionesVehiculo restriccion = restriccionOptional.get();
            modelMapper.map(vO, restriccion);
            restriccionesVehiculoRepository.save(restriccion);
        } else {
            throw new IllegalArgumentException("Restricción de vehículo no encontrada");
        }
    }

    // Método para obtener una restricción de vehículo por ID
    public RestriccionesVehiculoDTO getById(Long id) {
        Optional<RestriccionesVehiculo> restriccionOptional = restriccionesVehiculoRepository.findById(id);
        return restriccionOptional.map(restriccion -> modelMapper.map(restriccion, RestriccionesVehiculoDTO.class))
                                  .orElseThrow(() -> new IllegalArgumentException("Restricción de vehículo no encontrada"));
    }

    // Método para obtener todas las restricciones de vehículo con paginación
    public Page<RestriccionesVehiculoDTO> query(Pageable pageable) {
        return restriccionesVehiculoRepository.findAll(pageable)
                .map(restriccion -> modelMapper.map(restriccion, RestriccionesVehiculoDTO.class));
    }
}