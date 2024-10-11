package com.example.project.project_io.service;

import com.example.project.project_io.dtos.TipoVehiculoDTO;
import com.example.project.project_io.vo.TipoVehiculoVO;
import com.example.project.project_io.entities.TipoVehiculo;
import com.example.project.project_io.repository.TipoVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoVehiculoService {

    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un tipo de vehículo
    public Long save(TipoVehiculoVO vO) {
        TipoVehiculo tipoVehiculo = modelMapper.map(vO, TipoVehiculo.class);
        tipoVehiculo = tipoVehiculoRepository.save(tipoVehiculo);
        return tipoVehiculo.getIdTipoVehiculo();
    }

    // Método para eliminar un tipo de vehículo por ID
    public void delete(Long id) {
        tipoVehiculoRepository.deleteById(id);
    }

    // Método para actualizar un tipo de vehículo
    public void update(Long id, TipoVehiculoVO vO) {
        Optional<TipoVehiculo> tipoVehiculoOptional = tipoVehiculoRepository.findById(id);
        if (tipoVehiculoOptional.isPresent()) {
            TipoVehiculo tipoVehiculo = tipoVehiculoOptional.get();
            modelMapper.map(vO, tipoVehiculo);
            tipoVehiculoRepository.save(tipoVehiculo);
        } else {
            throw new IllegalArgumentException("Tipo de vehículo no encontrado");
        }
    }

    // Método para obtener un tipo de vehículo por ID
    public TipoVehiculoDTO getById(Long id) {
        Optional<TipoVehiculo> tipoVehiculoOptional = tipoVehiculoRepository.findById(id);
        return tipoVehiculoOptional.map(tipoVehiculo -> modelMapper.map(tipoVehiculo, TipoVehiculoDTO.class))
                                   .orElseThrow(() -> new IllegalArgumentException("Tipo de vehículo no encontrado"));
    }

    // Método para obtener todos los tipos de vehículo con paginación
    public Page<TipoVehiculoDTO> query(Pageable pageable) {
        return tipoVehiculoRepository.findAll(pageable)
                .map(tipoVehiculo -> modelMapper.map(tipoVehiculo, TipoVehiculoDTO.class));
    }
}