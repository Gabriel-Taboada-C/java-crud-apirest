package com.gabtaboada.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //Agrego este @ para que java sepa que esta clase es del tipo entity
public class Producto {
    
    @Id // Identificador unico de cada registro (clave primaria)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Creo una estrategia de generacion de clave (en aumento de 0 a n)
    private Long id;
    private String nombre;
    private double precio;

    //Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

    
}
