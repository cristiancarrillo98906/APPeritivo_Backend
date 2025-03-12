package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.ReservationModel;

import java.util.ArrayList;

public interface IReservationService {
    ArrayList<ReservationModel> obtenerTodasReservas();
    ReservationModel obtenerReservaPorId(Long id);
    ReservationModel crearReserva(ReservationModel r);
    ReservationModel actualizarReserva(Long id, ReservationModel r);
    ReservationModel eliminarReserva(Long id);
}

