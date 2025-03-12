package com.POOSpringBoot.POOSpringBoot.models;

public class ReviewModel {
    private  Long idReview;
    private  Long idUsuario;
    private  Long idRestaurante;
    private String comentario;
    private int valoracion;
    private String fecha;

    public ReviewModel() {
    }

    public ReviewModel(Long idReview, Long idUsuario, Long idRestaurante, String comentario, int valoracion, String fecha) {
        this.idReview = idReview;
        this.idUsuario = idUsuario;
        this.idRestaurante = idRestaurante;
        this.comentario = comentario;
        this.valoracion = valoracion;
        this.fecha = fecha;
    }

    public Long getIdReview() {
        return idReview;
    }

    public void setIdReview(Long idReview) {
        this.idReview = idReview;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
