package com.example.project.project_io.service;

import com.example.project.project_io.dtos.ConsumoGasolinaDTO;
import com.example.project.project_io.vo.ConsumoGasolinaVO;
import com.example.project.project_io.entities.ConsumoGasolina;
import com.example.project.project_io.repository.ConsumoGasolinaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsumoGasolinaService {

    @Autowired
    private ConsumoGasolinaRepository consumoGasolinaRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un registro de consumo de gasolina
    public Long save(ConsumoGasolinaVO vO) {
        ConsumoGasolina consumoGasolina = modelMapper.map(vO, ConsumoGasolina.class);
        consumoGasolina = consumoGasolinaRepository.save(consumoGasolina);
        return consumoGasolina.getId();
    }

    // Método para eliminar un registro por ID
    public void delete(Long id) {
        consumoGasolinaRepository.deleteById(id);
    }

    // Método para actualizar un registro de consumo de gasolina
    public void update(Long id, ConsumoGasolinaVO vO) {
        Optional<ConsumoGasolina> consumoGasolinaOptional = consumoGasolinaRepository.findById(id);
        if (consumoGasolinaOptional.isPresent()) {
            ConsumoGasolina consumoGasolina = consumoGasolinaOptional.get();
            modelMapper.map(vO, consumoGasolina);
            consumoGasolinaRepository.save(consumoGasolina);
        } else {
            throw new IllegalArgumentException("Registro de consumo de gasolina no encontrado");
        }
    }

    // Método para obtener un registro por ID
    public ConsumoGasolinaDTO getById(Long id) {
        Optional<ConsumoGasolina> consumoGasolinaOptional = consumoGasolinaRepository.findById(id);
        return consumoGasolinaOptional.map(consumoGasolina -> modelMapper.map(consumoGasolina, ConsumoGasolinaDTO.class))
                                      .orElseThrow(() -> new IllegalArgumentException("Registro de consumo de gasolina no encontrado"));
    }

    // Método para obtener todos los registros con paginación
    public Page<ConsumoGasolinaDTO> query(Pageable pageable) {
        return consumoGasolinaRepository.findAll(pageable)
                .map(consumoGasolina -> modelMapper.map(consumoGasolina, ConsumoGasolinaDTO.class));
    }
}