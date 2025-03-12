package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.EventModel;
import java.util.ArrayList;

public interface IEventService {
    ArrayList<EventModel> obtenerTodosEventos();
    EventModel obtenerEventoPorId(Long id);
    EventModel crearEvento(EventModel u);
    EventModel actualizarEvento(Long id, EventModel u);
    EventModel eliminarEvento(Long id);
}
