package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.EventModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
public class EventService implements IEventService{
    private static final String FILE_PATH = "eventos.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ArrayList<EventModel> obtenerTodosEventos() {
        ArrayList<EventModel> eventos = new ArrayList<>();
        try{
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            eventos = objectMapper.readValue(archivo,
                    new TypeReference<ArrayList<EventModel>>(){});
        }catch (IOException | URISyntaxException e){
            throw new RuntimeException(e);
        }
        return eventos;
    }

    @Override
    public EventModel obtenerEventoPorId(Long id) {
        ArrayList<EventModel> eventos = this.obtenerTodosEventos();
        for(EventModel e:eventos){
            if(e.getIdEvent() == id){
                return e;
            }
        }
        return new EventModel();
    }

    @Override
    public EventModel crearEvento(EventModel e) {
        ArrayList<EventModel> eventos = this.obtenerTodosEventos();
        Long id = 1L;
        if(!eventos.isEmpty()){
            id = eventos.get(eventos.size() - 1).getIdEvent() + 1;
        }
        e.setIdEvent(id);
        eventos.add(e);
        try{
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            objectMapper.writeValue(archivo,eventos);
        }catch (IOException | URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
        return e;
    }

    @Override
    public EventModel actualizarEvento(Long id, EventModel e) {
        ArrayList<EventModel> eventos = this.obtenerTodosEventos();
        EventModel eventoEncontrado = null;
        for(EventModel event: eventos) {
            if (event.getIdEvent() == id) {
                event.setNombre(e.getNombre());
                event.setDescripcion(e.getDescripcion());
                event.setFecha(e.getFecha());
                event.setIdRestaurant(e.getIdRestaurant());
                eventoEncontrado = event;
                break;
            }
        }
        if(eventoEncontrado != null &&
                eventoEncontrado.getIdEvent() == id){
            try{
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo,eventos);
            }catch (IOException | URISyntaxException ex){
                throw new RuntimeException(ex);
            }
        }
        return eventoEncontrado;
    }

    @Override
    public EventModel eliminarEvento(Long id) {
        ArrayList<EventModel> eventos = this.obtenerTodosEventos();
        EventModel eventoEliminado = null;
        for(EventModel event: eventos){
            if(event.getIdEvent() == id){
                eventos.remove(event);
                eventoEliminado = event;
                break;
            }
        }
        if(eventoEliminado != null &&
                eventoEliminado.getIdEvent() == id){
            try{
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo,eventos);
            }catch (IOException | URISyntaxException e){
                throw new RuntimeException(e);
            }
        }
        return eventoEliminado;
    }
}
