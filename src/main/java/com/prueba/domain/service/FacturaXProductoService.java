package com.prueba.domain.service;


import com.prueba.domain.repository.FacturaRepository;
import com.prueba.domain.repository.FacturaXProductoRepository;
import com.prueba.persistence.Factura;
import com.prueba.persistence.dtos.FacturaXProductoDTO;
import com.prueba.persistence.facturaXproducto.FacturaXProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaXProductoService implements ServiceInterface<FacturaXProductoDTO>{

    private final FacturaXProductoRepository facturaXProductoRepository;

    @Autowired
    public FacturaXProductoService(FacturaXProductoRepository facturaXProductoRepository) {
        this.facturaXProductoRepository = facturaXProductoRepository;
    }

    @Override
    public List<FacturaXProductoDTO> getAll() {
        return facturaXProductoRepository.findAll().stream()
                .map(FacturaXProducto :: toDTO)
                .toList();
    }


}
