package com.prueba.domain.service;

import com.prueba.domain.repository.TransaccionRepository;
import com.prueba.persistence.Transaccion;
import com.prueba.persistence.dtos.TransaccionDTO;
import com.prueba.persistence.facturaXproducto.FacturaXProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService implements ServiceInterface<TransaccionDTO>{

    private final TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    @Override
    public List<TransaccionDTO> getAll() {
        return transaccionRepository.findAll().stream()
                .map(Transaccion:: toDTO)
                .toList();
    }
}
