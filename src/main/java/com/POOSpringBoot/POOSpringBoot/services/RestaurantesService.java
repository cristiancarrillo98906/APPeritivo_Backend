package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.RestaurantesModel;
import com.POOSpringBoot.POOSpringBoot.models.UserModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
public class RestaurantesService implements IRestaurantesService{
    private static final String FILE_PATH = "restaurantes.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public ArrayList<RestaurantesModel> obtenerTodosRestaurantes() {
        ArrayList<RestaurantesModel> restaurantesModels = new ArrayList<>();
        try {
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            restaurantesModels = objectMapper.readValue(archivo, new
                    TypeReference<ArrayList<RestaurantesModel>>(){});
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return restaurantesModels;
    }

    @Override
    public RestaurantesModel obtenerRestaurantePorId(Long id) {
        ArrayList<RestaurantesModel> restaurantesModels = this.obtenerTodosRestaurantes();
        for (RestaurantesModel r: restaurantesModels){
            if (r.getId() == id){
                return r;
            }
        }
        return new RestaurantesModel();
    }

    @Override
    public RestaurantesModel crearRestaurante(RestaurantesModel r) {
        ArrayList<RestaurantesModel> restaurantesModels = this.obtenerTodosRestaurantes();
        Long id = 1L;
        if (!restaurantesModels.isEmpty()){
            id = restaurantesModels.get(restaurantesModels.size() - 1).getId() + 1;
        }
        r.setId(id);
        restaurantesModels.add(r);
        try {
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            objectMapper.writeValue(archivo, restaurantesModels);
        } catch (IOException | URISyntaxException e){
            throw new RuntimeException(e);
        }
        return r;
    }

    @Override
    public RestaurantesModel actualizarRestaurante(Long id, RestaurantesModel r) {
        ArrayList<RestaurantesModel> restaurantesModels = this.obtenerTodosRestaurantes();
        RestaurantesModel restauranteEncontrado = null;
        for (RestaurantesModel rest: restaurantesModels){
            if (rest.getId() == id){
                rest.setNombre(r.getNombre());
                rest.setUbicacion(r.getUbicacion());
                rest.setUbicacion(r.getUbicacion());
                rest.setPropietario(r.getPropietario());
                restauranteEncontrado = rest;
                break;
            }
        }

        if (restauranteEncontrado != null && restauranteEncontrado.getId() ==id){
            try{
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo, restaurantesModels);
            } catch (IOException | URISyntaxException e){
                throw new RuntimeException(e);
            }
        }
        return restauranteEncontrado;
    }

    @Override
    public RestaurantesModel eliminarRestaurante(Long id) {
        ArrayList<RestaurantesModel> restaurantesModels = this.obtenerTodosRestaurantes();
        RestaurantesModel restauranteEliminado = null;

        for (RestaurantesModel rest: restaurantesModels){
            if (rest.getId() == id){
                restaurantesModels.remove(rest);
                restauranteEliminado = rest;
                break;
            }
        }

        if (restauranteEliminado != null && restauranteEliminado.getId() == id){
            try {
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo, restaurantesModels);
            } catch (IOException |URISyntaxException e){
                throw new RuntimeException(e);
            }
        }
        return restauranteEliminado;
    }
}
