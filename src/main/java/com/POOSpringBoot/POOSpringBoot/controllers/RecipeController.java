package com.POOSpringBoot.POOSpringBoot.controllers;

import com.POOSpringBoot.POOSpringBoot.models.RecipeModel;
import com.POOSpringBoot.POOSpringBoot.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/recetas")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @GetMapping
    public ArrayList<RecipeModel> obtenertodas(){
        return recipeService.obtenerTodasRecetas();
    }
    @GetMapping("/{id}")
    public RecipeModel obtenerReceta(@PathVariable Long id){
        return recipeService.obtenerRecetaPorId(id);
    }
    @PostMapping
    public RecipeModel newReceta(@RequestBody RecipeModel r){
        return recipeService.crearReceta(r);
    }
    @PutMapping("/{id}")
    public RecipeModel updateReceta(@PathVariable Long id,
                                    @RequestBody RecipeModel r){
        return recipeService.actualizarReceta(id, r);
    }
    @DeleteMapping("/{id}")
    public RecipeModel deleteReceta(@PathVariable Long id){
        return recipeService.eliminarReceta(id);
    }
}
