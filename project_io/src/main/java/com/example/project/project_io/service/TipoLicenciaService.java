package com.example.project.project_io.service;

import com.example.project.project_io.dtos.TipoLicenciaDTO;
import com.example.project.project_io.entities.TipoLicencia;
import com.example.project.project_io.repository.TipoLicenciaRepository;
import com.example.project.project_io.vo.TipoLicenciaVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoLicenciaService {

    @Autowired
    private TipoLicenciaRepository tipoLicenciaRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un tipo de licencia
    public Long save(TipoLicenciaVO vO) {
        TipoLicencia tipoLicencia = modelMapper.map(vO, TipoLicencia.class);
        tipoLicencia = tipoLicenciaRepository.save(tipoLicencia);
        return tipoLicencia.getIdTipoLicencia();
    }

    // Método para eliminar un tipo de licencia por ID
    public void delete(Long id) {
        tipoLicenciaRepository.deleteById(id);
    }

    // Método para actualizar un tipo de licencia
    public void update(Long id, TipoLicenciaVO vO) {
        Optional<TipoLicencia> tipoLicenciaOptional = tipoLicenciaRepository.findById(id);
        if (tipoLicenciaOptional.isPresent()) {
            TipoLicencia tipoLicencia = tipoLicenciaOptional.get();
            modelMapper.map(vO, tipoLicencia);
            tipoLicenciaRepository.save(tipoLicencia);
        } else {
            throw new IllegalArgumentException("Tipo de licencia no encontrado");
        }
    }

    // Método para obtener un tipo de licencia por ID
    public TipoLicenciaDTO getById(Long id) {
        Optional<TipoLicencia> tipoLicenciaOptional = tipoLicenciaRepository.findById(id);
        return tipoLicenciaOptional.map(tipoLicencia -> modelMapper.map(tipoLicencia, TipoLicenciaDTO.class))
                                   .orElseThrow(() -> new IllegalArgumentException("Tipo de licencia no encontrado"));
    }

    // Método para obtener todos los tipos de licencia con paginación
    public Page<TipoLicenciaDTO> query(Pageable pageable) {
        return tipoLicenciaRepository.findAll(pageable)
                .map(tipoLicencia -> modelMapper.map(tipoLicencia, TipoLicenciaDTO.class));
    }
}