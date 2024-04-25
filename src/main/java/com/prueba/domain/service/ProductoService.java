package com.prueba.domain.service;

import com.prueba.domain.repository.ProductoRepository;
import com.prueba.persistence.Producto;
import com.prueba.persistence.dtos.ProductoDTO;
import com.prueba.persistence.facturaXproducto.FacturaXProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements ServiceInterface<ProductoDTO>{

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoDTO> getAll() {
        return productoRepository.findAll().stream()
                .map(Producto :: toDTO)
                .toList();
    }
}
