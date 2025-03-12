package com.POOSpringBoot.POOSpringBoot.controllers;

import com.POOSpringBoot.POOSpringBoot.models.FavoritosModel;
import com.POOSpringBoot.POOSpringBoot.services.FavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/favoritos")
public class FavoritosController {

    @Autowired
    private FavoritosService favoritosService;

    @GetMapping
    public ArrayList<FavoritosModel> obtenerTodos(){
        return favoritosService.obtenerTodosFavoritos();
    }

    @GetMapping("/{id}")
    public FavoritosModel obtenerFavorito(@PathVariable Long id){
        return favoritosService.obtenerFavoritoPorId(id);
    }

    @PostMapping
    public FavoritosModel newFavorito(@RequestBody FavoritosModel f){
        return favoritosService.crearFavorito(f);
    }

    @PutMapping("/{id}")
    public FavoritosModel updateFavorito(@PathVariable Long id, @RequestBody FavoritosModel f){
        return favoritosService.actualizarFavorito(id, f);
    }

    @DeleteMapping("/{id}")
    public FavoritosModel deleteFavorito(@PathVariable Long id){
        return favoritosService.eliminarFavorito(id);
    }

}
