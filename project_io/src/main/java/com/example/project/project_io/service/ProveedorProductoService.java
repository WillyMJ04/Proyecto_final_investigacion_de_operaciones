package com.example.project.project_io.service;

import com.example.project.project_io.dtos.ProveedorProductoDTO;
import com.example.project.project_io.vo.ProveedorProductoVO;
import com.example.project.project_io.entities.ProveedorProducto;
import com.example.project.project_io.repository.ProveedorProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ProveedorProductoService {
    @Autowired
    private ProveedorProductoRepository proveedorProductoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Long save(ProveedorProductoVO vO) {
        ProveedorProducto proveedorProducto = modelMapper.map(vO, ProveedorProducto.class);
        proveedorProducto = proveedorProductoRepository.save(proveedorProducto);
        return proveedorProducto.getId();
    }

    public void delete(Long id) {
        proveedorProductoRepository.deleteById(id);
    }

    public void update(Long id, ProveedorProductoVO vO) {
        Optional<ProveedorProducto> proveedorProductoOptional =

 proveedorProductoRepository.findById(id);
        if (proveedorProductoOptional.isPresent()) {
            ProveedorProducto proveedorProducto = proveedorProductoOptional.get();
            modelMapper.map(vO, proveedorProducto);
            proveedorProductoRepository.save(proveedorProducto);
        } else {
            throw new IllegalArgumentException("Relación Proveedor-Producto no encontrada");
        }
    }

    public ProveedorProductoDTO getById(Long id) {
        Optional<ProveedorProducto> proveedorProductoOptional = proveedorProductoRepository.findById(id);
        return proveedorProductoOptional.map(proveedorProducto -> modelMapper.map(proveedorProducto, ProveedorProductoDTO.class))
                .orElseThrow(() -> new IllegalArgumentException("Relación Proveedor-Producto no encontrada"));
    }
}
