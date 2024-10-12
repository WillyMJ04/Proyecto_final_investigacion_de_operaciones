package com.example.project.project_io.service;

import com.example.project.project_io.dtos.ProveedorDTO;
import com.example.project.project_io.vo.ProveedorVO;
import com.example.project.project_io.entities.Proveedor;
import com.example.project.project_io.repository.ProveedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un proveedor
    public Long save(ProveedorVO vO) {
        Proveedor proveedor = modelMapper.map(vO, Proveedor.class);
        proveedor = proveedorRepository.save(proveedor);
        return proveedor.getIdProveedor();
    }

    // Método para eliminar un proveedor por ID
    public void delete(Long id) {
        proveedorRepository.deleteById(id);
    }

    // Método para actualizar un proveedor
    public <ProveedorUpdateVO> void update(Long id, ProveedorUpdateVO vO) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        if (proveedorOptional.isPresent()) {
            Proveedor proveedor = proveedorOptional.get();
            modelMapper.map(vO, proveedor); // Mapeo de VO a la entidad
            proveedorRepository.save(proveedor);
        } else {
            throw new IllegalArgumentException("Proveedor no encontrado");
        }
    }

    // Método para obtener un proveedor por ID
    public ProveedorDTO getById(Long id) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        return proveedorOptional.map(proveedor -> modelMapper.map(proveedor, ProveedorDTO.class))
                .orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado"));
    }

    // Método para realizar consultas paginadas de proveedores
    public Page<ProveedorDTO> query(Pageable pageable) {
        return proveedorRepository.findAll(pageable)
                .map(proveedor -> modelMapper.map(proveedor, ProveedorDTO.class));
    }
}