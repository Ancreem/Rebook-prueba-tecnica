package com.prueba.web.controller;

import com.prueba.domain.service.FacturaService;
import com.prueba.persistence.Factura;
import com.prueba.persistence.dtos.FacturaDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/factura")
@CrossOrigin("https://localhost:8080")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class FacturaController {
    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<FacturaDTO> getAllFactura() {
        return facturaService.getAll();
    }
}
