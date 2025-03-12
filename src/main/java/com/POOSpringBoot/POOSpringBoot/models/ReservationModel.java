package com.POOSpringBoot.POOSpringBoot.models;

public class ReservationModel {
    private  Long idReserva;
    private  Long idUsuario;
    private  Long idRestaurante;
    private String fecha;
    private int numPer;

    public ReservationModel(){
    }

    public ReservationModel(Long idReserva, Long idUsuario, Long idRestaurante, String fecha, int numPer) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.idRestaurante = idRestaurante;
        this.fecha = fecha;
        this.numPer = numPer;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumPer() {
        return numPer;
    }

    public void setNumPer(int numPer) {
        this.numPer = numPer;
    }
}
