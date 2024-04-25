package com.prueba.persistence;

import com.prueba.persistence.dtos.ProductoDTO;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name= "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private double precio;

    public Producto() {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ProductoDTO toDTO(){
        ProductoDTO dto = new ProductoDTO();

        dto.setId(this.id);
        dto.setNombre(this.nombre);
        dto.setPrecio(this.precio);

        return dto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
