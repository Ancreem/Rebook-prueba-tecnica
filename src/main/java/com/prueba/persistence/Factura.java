package com.prueba.persistence;

import com.prueba.persistence.dtos.FacturaDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @JoinColumn(name="cliente_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;


    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Transaccion> transacciones;

    public Factura() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public FacturaDTO toDTO(){
        FacturaDTO dto = new FacturaDTO();

        dto.setId(this.id);
        dto.setFecha(this.fecha);
        dto.setClienteId(this.cliente != null ? this.cliente.getId() : null);

        return dto;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", transacciones=" + transacciones +
                '}';
    }
}
