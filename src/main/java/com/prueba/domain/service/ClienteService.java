package com.prueba.domain.service;

import com.prueba.domain.repository.ClienteRepository;
import com.prueba.persistence.Cliente;
import com.prueba.persistence.dtos.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements ServiceInterface<ClienteDTO> {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteDTO> getAll() {
        return clienteRepository.findAll().stream()
                .map(Cliente::toDTO)
                .toList();
    }
}
