package com.prueba.web.controller;

import com.prueba.domain.service.FacturaXProductoService;
import com.prueba.persistence.dtos.FacturaXProductoDTO;
import com.prueba.persistence.facturaXproducto.FacturaXProducto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facturaXproducto")
@CrossOrigin("https://localhost:8080")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class FacturaXProductoController {
    private final FacturaXProductoService facturaXProductoService;

    @Autowired
    public FacturaXProductoController(FacturaXProductoService facturaXProductoService) {
        this.facturaXProductoService = facturaXProductoService;
    }

    @GetMapping
    public List<FacturaXProductoDTO> getAllFacturaXProducto() {
        return facturaXProductoService.getAll();
    }


}
