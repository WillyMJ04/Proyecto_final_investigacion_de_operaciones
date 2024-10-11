package com.example.project.project_io.service;

import com.example.project.project_io.dtos.PedidoDTO;
import com.example.project.project_io.entities.Pedido;
import com.example.project.project_io.repository.PedidoRepository;
import com.example.project.project_io.vo.PedidoVO;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un pedido
    public Long save(@Valid PedidoVO vO) {
        Pedido pedido = modelMapper.map(vO, Pedido.class);
        pedido = pedidoRepository.save(pedido);
        return pedido.getIdPedido();
    }

    // Método para eliminar un pedido por ID
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

    // Método para actualizar un pedido
    public void update(Long id, PedidoVO vO) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            modelMapper.map(vO, pedido);
            pedidoRepository.save(pedido);
        } else {
            throw new IllegalArgumentException("Pedido no encontrado");
        }
    }

    // Método para obtener un pedido por ID
    public PedidoDTO getById(Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        return pedidoOptional.map(pedido -> modelMapper.map(pedido, PedidoDTO.class))
                             .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
    }

    // Método para obtener todos los pedidos con paginación
    public Page<PedidoDTO> query(Pageable pageable) {
        return pedidoRepository.findAll(pageable)
                .map(pedido -> modelMapper.map(pedido, PedidoDTO.class));
    }
}