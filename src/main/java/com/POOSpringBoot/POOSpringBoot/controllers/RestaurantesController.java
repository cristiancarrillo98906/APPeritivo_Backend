package com.POOSpringBoot.POOSpringBoot.controllers;

import com.POOSpringBoot.POOSpringBoot.models.RestaurantesModel;
import com.POOSpringBoot.POOSpringBoot.services.RestaurantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/restaurantes")
public class RestaurantesController {

    @Autowired
    private RestaurantesService restaurantesService;

    @GetMapping
    public ArrayList<RestaurantesModel> obtenerTodos(){
        return restaurantesService.obtenerTodosRestaurantes();
    }

    @GetMapping("/{id}")
    public RestaurantesModel obtenerRestaurante(@PathVariable Long id){
        return restaurantesService.obtenerRestaurantePorId(id);
    }

    @PostMapping
    public RestaurantesModel newRestaurante(@RequestBody RestaurantesModel r){
        return restaurantesService.crearRestaurante(r);
    }

    @PutMapping("/{id}")
    public RestaurantesModel updateRestaurante(@PathVariable Long id, @RequestBody RestaurantesModel r){
        return restaurantesService.actualizarRestaurante(id, r);
    }

    @DeleteMapping("/{id}")
    public RestaurantesModel deleteRestaurante(@PathVariable Long id){
        return restaurantesService.eliminarRestaurante(id);
    }

}
