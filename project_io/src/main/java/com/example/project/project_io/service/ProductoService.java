package com.example.project.project_io.service;

import com.example.project.project_io.dtos.ProductoDTO;
import com.example.project.project_io.entities.Producto;
import com.example.project.project_io.repository.ProductoRepository;
import com.example.project.project_io.vo.ProductoUpdateVO;
import com.example.project.project_io.vo.ProductoVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Long save(ProductoVO vO) {
        Producto producto = modelMapper.map(vO, Producto.class);
        producto = productoRepository.save(producto);
        return producto.getId();
    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    public void update(Long id, ProductoUpdateVO vO) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            modelMapper.map(vO, producto);
            productoRepository.save(producto);
        } else {
            throw new IllegalArgumentException("Producto no encontrado");
        }
    }

    public ProductoDTO getById(Long id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        return productoOptional.map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
    }

    // Método corregido para devolver una List<ProductoDTO> en lugar de Page<ProductoDTO>
    public List<ProductoDTO> query() {
        return productoRepository.findAll()
                .stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .toList();
    }
}