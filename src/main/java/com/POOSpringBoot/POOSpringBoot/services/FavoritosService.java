package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.FavoritosModel;
import com.POOSpringBoot.POOSpringBoot.models.RestaurantesModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
public class FavoritosService implements IFavoritosService {
    private static final String FILE_PATH = "favoritos.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ArrayList<FavoritosModel> obtenerTodosFavoritos() {
        ArrayList<FavoritosModel> favoritosModels = new ArrayList<>();
        try {
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            favoritosModels = objectMapper.readValue(archivo, new
                    TypeReference<ArrayList<FavoritosModel>>(){});
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return favoritosModels;
    }

    @Override
    public FavoritosModel obtenerFavoritoPorId(Long id) {
        ArrayList<FavoritosModel> favoritosModels = this.obtenerTodosFavoritos();
        for (FavoritosModel f: favoritosModels){
            if (f.getId() == id){
                return f;
            }
        }
        return new FavoritosModel();
    }

    @Override
    public FavoritosModel crearFavorito(FavoritosModel f) {
        ArrayList<FavoritosModel> favoritosModels = this.obtenerTodosFavoritos();
        Long id = 1L;
        if (!favoritosModels.isEmpty()){
            id = favoritosModels.get(favoritosModels.size() - 1).getId() + 1;
        }
        f.setId(id);
        favoritosModels.add(f);
        try {
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            objectMapper.writeValue(archivo, favoritosModels);
        } catch (IOException | URISyntaxException e){
            throw new RuntimeException(e);
        }
        return f;
    }

    @Override
    public FavoritosModel actualizarFavorito(Long id, FavoritosModel f) {
        ArrayList<FavoritosModel> favoritosModels = this.obtenerTodosFavoritos();
        FavoritosModel favoritoEncontrado = null;
        for (FavoritosModel rest: favoritosModels){
            if (rest.getId() == id){
                rest.setUsuario_id(f.getUsuario_id());
                rest.setRestaurante_id(f.getRestaurante_id());
                rest.setFecha_agregado(f.getFecha_agregado());
                favoritoEncontrado = rest;
                break;
            }
        }

        if (favoritoEncontrado != null && favoritoEncontrado.getId() ==id){
            try{
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo, favoritosModels);
            } catch (IOException | URISyntaxException e){
                throw new RuntimeException(e);
            }
        }
        return favoritoEncontrado;
    }

    @Override
    public FavoritosModel eliminarFavorito(Long id) {
        ArrayList<FavoritosModel> favoritosModels = this.obtenerTodosFavoritos();
        FavoritosModel favoritoEliminado = null;

        for (FavoritosModel rest: favoritosModels){
            if (rest.getId() == id){
                favoritosModels.remove(rest);
                favoritoEliminado = rest;
                break;
            }
        }

        if (favoritoEliminado != null && favoritoEliminado.getId() == id){
            try {
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo, favoritosModels);
            } catch (IOException |URISyntaxException e){
                throw new RuntimeException(e);
            }
        }
        return favoritoEliminado;
    }
}
