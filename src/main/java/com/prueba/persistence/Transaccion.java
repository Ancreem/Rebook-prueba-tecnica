package com.prueba.persistence;

import com.prueba.persistence.dtos.TransaccionDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "Transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero_transaccion", nullable = false)
    private Integer numeroTransaccion;

    @Column(name = "nombre_titular", nullable = false)
    private String nombreTitular;

    @Column(name = "monto_transaccion", nullable = false)
    private Integer montoTransaccion;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    public Transaccion() {
    }

    public Integer getId() {
        return id;
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

    public Integer getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(Integer montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public TransaccionDTO toDTO(){
        TransaccionDTO dto = new TransaccionDTO();

        dto.setId(this.id);
        dto.setFecha(this.fecha);
        dto.setMontoTransaccion(this.montoTransaccion);
        dto.setNombreTitular(this.nombreTitular);
        dto.setNumeroTransaccion(this.numeroTransaccion);
        dto.setFacturaId(this.factura != null ? this.factura.getId() : null);

        return dto;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "id=" + id +
                ", numeroTransaccion=" + numeroTransaccion +
                ", nombreTitular='" + nombreTitular + '\'' +
                ", montoTransaccion=" + montoTransaccion +
                ", fecha=" + fecha +
                ", factura=" + factura +
                '}';
    }
}
