package com.prueba.persistence.dtos;

public class FacturaXProductoDTO {
    private Integer facturaId;
    private Integer productoId;
    private Integer cantidad;

    public FacturaXProductoDTO() {
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
