package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.RecipeModel;

import java.util.ArrayList;

public interface IRecipeService {
    ArrayList<RecipeModel> obtenerTodasRecetas();
    RecipeModel obtenerRecetaPorId(Long id);
    RecipeModel crearReceta(RecipeModel u);
    RecipeModel actualizarReceta(Long id, RecipeModel u);
    RecipeModel eliminarReceta(Long id);
}
