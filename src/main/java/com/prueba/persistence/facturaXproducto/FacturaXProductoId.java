package com.prueba.persistence.facturaXproducto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FacturaXProductoId {

    @Column(name = "producto_id")
    private Integer productoId;

    @Column(name = "factura_id")
    private Integer facturaId;

    public FacturaXProductoId() {
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }
}
