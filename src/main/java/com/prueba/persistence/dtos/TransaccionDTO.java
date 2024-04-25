package com.prueba.persistence.dtos;

import java.time.LocalDate;

public class TransaccionDTO {
    private Integer id;
    private Integer numeroTransaccion;
    private String nombreTitular;
    private double montoTransaccion;
    private LocalDate fecha;
    private Integer facturaId;

    public TransaccionDTO() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(Integer numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public double getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(double montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
