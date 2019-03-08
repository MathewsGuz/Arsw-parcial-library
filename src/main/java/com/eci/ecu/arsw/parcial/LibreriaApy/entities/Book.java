/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eci.ecu.arsw.parcial.LibreriaApy.entities;

/**
 *
 * @author 2108263
 */
public class Book {
    String nombre;
    Integer id;
    String autor;
    String sinopsis;
    Integer libreriaId;

    public Book(String nombre, Integer id, String autor, String sinopsis, Integer libreriaId) {
        this.nombre = nombre;
        this.id = id;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.libreriaId = libreriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Integer getLibreriaId() {
        return libreriaId;
    }

    public void setLibreriaId(Integer libreriaId) {
        this.libreriaId = libreriaId;
    }
    
    
    
    
}
