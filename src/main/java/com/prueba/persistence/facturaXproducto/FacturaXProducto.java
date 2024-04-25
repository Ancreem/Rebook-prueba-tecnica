package com.prueba.persistence.facturaXproducto;


import com.prueba.persistence.Factura;
import com.prueba.persistence.Producto;
import com.prueba.persistence.dtos.FacturaXProductoDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "factura_x_producto")
public class FacturaXProducto {

    @EmbeddedId
    private FacturaXProductoId id;

    @ManyToOne
    @MapsId("facturaId")
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public FacturaXProducto() {
    }

    public FacturaXProductoId getId() {
        return id;
    }

    public void setId(FacturaXProductoId id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public FacturaXProductoDTO toDTO(){
        FacturaXProductoDTO dto = new FacturaXProductoDTO();

        dto.setFacturaId(this.getFactura().getId());
        dto.setProductoId(this.getProducto().getId());
        dto.setCantidad(this.cantidad);

        return dto;
    }

    @Override
    public String toString() {
        return "FacturaXProducto{" +
                "id=" + id +
                ", factura=" + factura +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}
