package com.example.project.project_io.service;

import com.example.project.project_io.dtos.ClienteDTO;
import com.example.project.project_io.vo.ClienteVO;
import com.example.project.project_io.entities.Cliente;
import com.example.project.project_io.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Método para guardar un cliente
    public Long save(ClienteVO vO) {
        Cliente cliente = modelMapper.map(vO, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return cliente.getId();
    }

    // Método para eliminar un cliente por ID
    public void delete(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente no encontrado para eliminar");
        }
        clienteRepository.deleteById(id);
    }

    // Método para actualizar un cliente
    public void update(Long id, ClienteVO vO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado para actualizar"));

        modelMapper.map(vO, cliente);
        clienteRepository.save(cliente);
    }

    // Método para obtener un cliente por ID
    public ClienteDTO getById(Long id) {
        return clienteRepository.findById(id)
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
    }

    // Método para obtener todos los clientes con paginación
    public Page<ClienteDTO> query(Pageable pageable) {
        return clienteRepository.findAll(pageable)
                .map(cliente -> modelMapper.map(cliente, ClienteDTO.class));
    }
}