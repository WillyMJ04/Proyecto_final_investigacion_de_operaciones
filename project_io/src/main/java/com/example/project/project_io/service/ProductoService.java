package com.example.project.project_io.service;

import com.example.project.project_io.dtos.ProductoDTO;
import com.example.project.project_io.vo.ProductoVO;
import com.example.project.project_io.vo.ProductoUpdateVO;
import com.example.project.project_io.entities.Producto;
import com.example.project.project_io.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return producto.getIdProducto();
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

    public Page<ProductoDTO> query(Pageable pageable) {
        return productoRepository.findAll(pageable)
                .map(producto -> modelMapper.map(producto, ProductoDTO.class));
    }
}