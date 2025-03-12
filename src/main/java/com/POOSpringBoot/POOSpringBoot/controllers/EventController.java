package com.POOSpringBoot.POOSpringBoot.controllers;

import com.POOSpringBoot.POOSpringBoot.models.EventModel;
import com.POOSpringBoot.POOSpringBoot.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/eventos")
public class EventController {
    @Autowired
    private EventService eventService;
    @GetMapping
    public ArrayList<EventModel> obtenertodas(){
        return eventService.obtenerTodosEventos();
    }
    @GetMapping("/{id}")
    public EventModel obtenerReceta(@PathVariable Long id){
        return eventService.obtenerEventoPorId(id);
    }
    @PostMapping
    public EventModel newReceta(@RequestBody EventModel r){
        return eventService.crearEvento(r);
    }
    @PutMapping("/{id}")
    public EventModel updateReceta(@PathVariable Long id,
                                   @RequestBody EventModel r){
        return eventService.actualizarEvento(id, r);
    }
    @DeleteMapping("/{id}")
    public EventModel deleteReceta(@PathVariable Long id){
        return eventService.eliminarEvento(id);
    }
}
