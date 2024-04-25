package com.prueba.domain.service;

import com.prueba.domain.repository.FacturaRepository;
import com.prueba.persistence.Factura;
import com.prueba.persistence.dtos.FacturaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService implements ServiceInterface<FacturaDTO>{

    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<FacturaDTO> getAll() {
        return facturaRepository.findAll().stream()
                .map(Factura::toDTO)
                .toList();
    }


}
