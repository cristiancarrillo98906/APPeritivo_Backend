package com.POOSpringBoot.POOSpringBoot.models;

import javax.print.DocFlavor;

public class RestaurantesModel {
    //Atributos
    private Long id;
    private String nombre;
    private String ubicacion;
    private String descripcion;
    private String propietario;

    public RestaurantesModel(){

    }

    public RestaurantesModel(Long id, String nombre, String ubicacion, String descripcion, String propietario) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.propietario = propietario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPropietario() {
        return this.propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

}
