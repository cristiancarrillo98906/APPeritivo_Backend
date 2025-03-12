package com.POOSpringBoot.POOSpringBoot.models;

public class EventModel {
    private Long idEvent;
    private String nombre;
    private String descripcion;
    private String fecha;
    private Long idRestaurant;

    //Constructor sin parámetros
    public EventModel(){
    }

    //Constructor parametrizado
    public EventModel(Long idEvent, String nombre, String descripcion, String fecha, Long idRestaurant) {
        this.idEvent = idEvent;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.idRestaurant = idRestaurant;
    }

    //Getter y Setter

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }
}
