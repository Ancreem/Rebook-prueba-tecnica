package com.prueba.persistence;

import com.prueba.persistence.dtos.ClienteDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "cedula", nullable = false, unique = true)
    private Integer cedula;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "numero_telefono", nullable = false, unique = true)
    private Integer numeroTelefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    public Cliente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(Integer numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public ClienteDTO toDTO(){
        ClienteDTO dto = new ClienteDTO();

        dto.setId(this.id);
        dto.setCedula(this.cedula);
        dto.setNombre(this.nombre);
        dto.setDireccion(this.direccion);
        dto.setNumeroTelefono(this.numeroTelefono);

        return dto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cedula=" + cedula +
                ", direccion='" + direccion + '\'' +
                ", numeroTelefono=" + numeroTelefono +
                ", facturas=" + facturas +
                '}';
    }
}
