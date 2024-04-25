package com.prueba.web.controller;

import com.prueba.domain.service.TransaccionService;
import com.prueba.persistence.Transaccion;
import com.prueba.persistence.dtos.TransaccionDTO;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaccion")
@CrossOrigin("*")
public class TransaccionController {

    private final TransaccionService transaccionService;

    @Autowired
    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping
    public List<TransaccionDTO> getAllTransaccion() {
        return transaccionService.getAll();
    }
}
