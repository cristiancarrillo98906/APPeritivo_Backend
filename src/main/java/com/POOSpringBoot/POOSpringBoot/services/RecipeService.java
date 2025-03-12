package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.RecipeModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
public class RecipeService implements IRecipeService {
    private static final String FILE_PATH = "recetas.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    //Obtener todos los usuarios
    @Override
    public ArrayList<RecipeModel> obtenerTodasRecetas() {
        ArrayList<RecipeModel> recetas = new ArrayList<>();
        try{
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            recetas = objectMapper.readValue(archivo,
                    new TypeReference<ArrayList<RecipeModel>>(){});
        }catch (IOException | URISyntaxException e){
            throw new RuntimeException(e);
        }
        return recetas;
    }

    @Override
    public RecipeModel obtenerRecetaPorId(Long id) {
        ArrayList<RecipeModel> recetas = this.obtenerTodasRecetas();
        for(RecipeModel r:recetas){
            if(r.getId() == id){
                return r;
            }
        }
        return new RecipeModel();
    }

    @Override
    public RecipeModel crearReceta(RecipeModel r) {
        ArrayList<RecipeModel> recetas = this.obtenerTodasRecetas();
        Long id = 1L;
        if(!recetas.isEmpty()){
            id = recetas.get(recetas.size() - 1).getId() + 1;
        }
        r.setId(id);
        recetas.add(r);
        try{
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            objectMapper.writeValue(archivo,recetas);
        }catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return r;
    }


    @Override
    public RecipeModel actualizarReceta(Long id, RecipeModel r) {
        ArrayList<RecipeModel> recetas = this.obtenerTodasRecetas();
        RecipeModel recetaEncontrada = null;
        for(RecipeModel recipe: recetas) {
            if (recipe.getId() == id) {
                recipe.setIngredientes(r.getIngredientes());
                recipe.setInstrucciones(r.getInstrucciones());
                recipe.setIngredientes(r.getIngredientes());
                recipe.setTitulo(r.getTitulo());
                recetaEncontrada = recipe;
                break;
            }
        }
        if(recetaEncontrada != null &&
                recetaEncontrada.getId() == id){
            try{
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo,recetas);
            }catch (IOException | URISyntaxException e){
                throw new RuntimeException(e);
            }
        }
        return recetaEncontrada;
    }

    @Override
    public RecipeModel eliminarReceta(Long id) {
        ArrayList<RecipeModel> recetas = this.obtenerTodasRecetas();
        RecipeModel recetaEliminada = null;
        for(RecipeModel recipe: recetas){
            if(recipe.getId() == id){
                recetas.remove(recipe);
                recetaEliminada = recipe;
                break;
            }
        }
        if(recetaEliminada != null &&
                recetaEliminada.getId() == id){
            try{
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo,recetas);
            }catch (IOException | URISyntaxException e){
                throw new RuntimeException(e);
            }
        }
        return recetaEliminada;
    }
}
