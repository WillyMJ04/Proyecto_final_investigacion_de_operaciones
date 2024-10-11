package com.example.project.project_io.service;

import com.example.project.project_io.dtos.ConductorPedidoDTO;
import com.example.project.project_io.vo.ConductorPedidoVO;
import com.example.project.project_io.entities.ConductorPedido;
import com.example.project.project_io.repository.ConductorPedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConductorPedidoService {

    @Autowired
    private ConductorPedidoRepository conductorPedidoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar una relación entre conductor y pedido
    public Long save(ConductorPedidoVO vO) {
        ConductorPedido conductorPedido = modelMapper.map(vO, ConductorPedido.class);
        conductorPedido = conductorPedidoRepository.save(conductorPedido);
        return conductorPedido.getId();
    }

    // Método para eliminar una relación conductor-pedido por ID
    public void delete(Long id) {
        conductorPedidoRepository.deleteById(id);
    }

    // Método para actualizar una relación conductor-pedido
    public void update(Long id, ConductorPedidoVO vO) {
        Optional<ConductorPedido> conductorPedidoOptional = conductorPedidoRepository.findById(id);
        if (conductorPedidoOptional.isPresent()) {
            ConductorPedido conductorPedido = conductorPedidoOptional.get();
            modelMapper.map(vO, conductorPedido);
            conductorPedidoRepository.save(conductorPedido);
        } else {
            throw new IllegalArgumentException("Relación Conductor-Pedido no encontrada");
        }
    }

    // Método para obtener una relación conductor-pedido por ID
    public ConductorPedidoDTO getById(Long id) {
        Optional<ConductorPedido> conductorPedidoOptional = conductorPedidoRepository.findById(id);
        return conductorPedidoOptional.map(conductorPedido -> modelMapper.map(conductorPedido, ConductorPedidoDTO.class))
                                      .orElseThrow(() -> new IllegalArgumentException("Relación Conductor-Pedido no encontrada"));
    }

    // Método para obtener una relación conductor-pedido por conductor y pedido
    public ConductorPedidoDTO findByConductorIdAndPedidoId(Long idConductor, Long idPedido) {
        ConductorPedido conductorPedido = conductorPedidoRepository.findByConductor_IdAndId(idConductor, idPedido);
        if (conductorPedido != null) {
            return modelMapper.map(conductorPedido, ConductorPedidoDTO.class);
        } else {
            throw new IllegalArgumentException("Relación Conductor-Pedido no encontrada");
        }
    }
}