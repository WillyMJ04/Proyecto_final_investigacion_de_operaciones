package com.example.project.project_io.service;

import com.example.project.project_io.dtos.VehiculoDTO;
import com.example.project.project_io.vo.VehiculoVO;
import com.example.project.project_io.entities.Vehiculo;
import com.example.project.project_io.repository.VehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un vehículo
    public Long save(VehiculoVO vO) {
        Vehiculo vehiculo = modelMapper.map(vO, Vehiculo.class);
        vehiculo = vehiculoRepository.save(vehiculo);
        return vehiculo.getIdVehiculo();
    }

    // Método para eliminar un vehículo por ID
    public void delete(Long id) {
        vehiculoRepository.deleteById(id);
    }

    // Método para actualizar un vehículo
    public void update(Long id, VehiculoVO vO) {
        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(id);
        if (vehiculoOptional.isPresent()) {
            Vehiculo vehiculo = vehiculoOptional.get();
            modelMapper.map(vO, vehiculo);
            vehiculoRepository.save(vehiculo);
        } else {
            throw new IllegalArgumentException("Vehículo no encontrado");
        }
    }

    // Método para obtener un vehículo por ID
    public VehiculoDTO getById(Long id) {
        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(id);
        return vehiculoOptional.map(vehiculo -> modelMapper.map(vehiculo, VehiculoDTO.class))
                               .orElseThrow(() -> new IllegalArgumentException("Vehículo no encontrado"));
    }

    // Método para obtener todos los vehículos con paginación
    public Page<VehiculoDTO> query(Pageable pageable) {
        return vehiculoRepository.findAll(pageable)
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoDTO.class));
    }
}