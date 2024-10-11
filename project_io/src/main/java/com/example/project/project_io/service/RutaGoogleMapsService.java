package com.example.project.project_io.service;

import com.example.project.project_io.dtos.RutaGoogleMapsDTO;
import com.example.project.project_io.entities.RutaGoogleMaps;
import com.example.project.project_io.repository.RutaGoogleMapsRepository;
import com.example.project.project_io.vo.RutaGoogleMapsVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RutaGoogleMapsService {

    @Autowired
    private RutaGoogleMapsRepository rutaGoogleMapsRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar una ruta de Google Maps
    public Long save(RutaGoogleMapsVO vO) {
        RutaGoogleMaps rutaGoogleMaps = modelMapper.map(vO, RutaGoogleMaps.class);
        rutaGoogleMaps = rutaGoogleMapsRepository.save(rutaGoogleMaps);
        return rutaGoogleMaps.getIdRutaGmaps();
    }

    // Método para eliminar una ruta de Google Maps por ID
    public void delete(Long id) {
        rutaGoogleMapsRepository.deleteById(id);
    }

    // Método para actualizar una ruta de Google Maps
    public void update(Long id, RutaGoogleMapsVO vO) {
        Optional<RutaGoogleMaps> rutaOptional = rutaGoogleMapsRepository.findById(id);
        if (rutaOptional.isPresent()) {
            RutaGoogleMaps rutaGoogleMaps = rutaOptional.get();
            modelMapper.map(vO, rutaGoogleMaps);
            rutaGoogleMapsRepository.save(rutaGoogleMaps);
        } else {
            throw new IllegalArgumentException("Ruta de Google Maps no encontrada");
        }
    }

    // Método para obtener una ruta de Google Maps por ID
    public RutaGoogleMapsDTO getById(Long id) {
        Optional<RutaGoogleMaps> rutaOptional = rutaGoogleMapsRepository.findById(id);
        return rutaOptional.map(rutaGoogleMaps -> modelMapper.map(rutaGoogleMaps, RutaGoogleMapsDTO.class))
                           .orElseThrow(() -> new IllegalArgumentException("Ruta de Google Maps no encontrada"));
    }

    // Método para obtener todas las rutas de Google Maps con paginación
    public Page<RutaGoogleMapsDTO> query(Pageable pageable) {
        return rutaGoogleMapsRepository.findAll(pageable)
                .map(rutaGoogleMaps -> modelMapper.map(rutaGoogleMaps, RutaGoogleMapsDTO.class));
    }
}