package com.example.project.project_io.service;

import com.example.project.project_io.dtos.DetallePedidoDTO;
import com.example.project.project_io.vo.DetallePedidoVO;
import com.example.project.project_io.entities.DetallePedido;
import com.example.project.project_io.repository.DetallePedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un detalle de pedido
    public Long save(DetallePedidoVO vO) {
        DetallePedido detallePedido = modelMapper.map(vO, DetallePedido.class);
        detallePedido = detallePedidoRepository.save(detallePedido);
        return detallePedido.getId();
    }

    // Método para eliminar un detalle de pedido por ID
    public void delete(Long id) {
        detallePedidoRepository.deleteById(id);
    }

    // Método para actualizar un detalle de pedido
    public void update(Long id, DetallePedidoVO vO) {
        Optional<DetallePedido> detallePedidoOptional = detallePedidoRepository.findById(id);
        if (detallePedidoOptional.isPresent()) {
            DetallePedido detallePedido = detallePedidoOptional.get();
            modelMapper.map(vO, detallePedido);
            detallePedidoRepository.save(detallePedido);
        } else {
            throw new IllegalArgumentException("Detalle de pedido no encontrado");
        }
    }

    // Método para obtener un detalle de pedido por ID
    public DetallePedidoDTO getById(Long id) {
        Optional<DetallePedido> detallePedidoOptional = detallePedidoRepository.findById(id);
        return detallePedidoOptional.map(detallePedido -> modelMapper.map(detallePedido, DetallePedidoDTO.class))
                                    .orElseThrow(() -> new IllegalArgumentException("Detalle de pedido no encontrado"));
    }

    // Método para obtener todos los detalles de pedido con paginación
    public Page<DetallePedidoDTO> query(Pageable pageable) {
        return detallePedidoRepository.findAll(pageable)
                .map(detallePedido -> modelMapper.map(detallePedido, DetallePedidoDTO.class));
    }
}