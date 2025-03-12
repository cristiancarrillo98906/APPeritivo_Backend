package com.POOSpringBoot.POOSpringBoot.models;

public class FavoritosModel {
    private Long id;
    private Long usuario_id;
    private Long restaurante_id;
    private String fecha_agregado;

    public FavoritosModel(){

    }

    public FavoritosModel(Long id, Long usuario_id, Long restaurante_id, String fecha_agregado) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.restaurante_id = restaurante_id;
        this.fecha_agregado = fecha_agregado;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuario_id() {
        return this.usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Long getRestaurante_id() {
        return this.restaurante_id;
    }

    public void setRestaurante_id(Long restaurante_id) {
        this.restaurante_id = restaurante_id;
    }

    public String getFecha_agregado() {
        return this.fecha_agregado;
    }

    public void setFecha_agregado(String fecha_agregado) {
        this.fecha_agregado = fecha_agregado;
    }
}
