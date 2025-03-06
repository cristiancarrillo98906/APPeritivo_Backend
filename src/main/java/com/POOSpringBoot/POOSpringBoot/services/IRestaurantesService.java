package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.RestaurantesModel;

import java.util.ArrayList;

public interface IRestaurantesService {
    ArrayList<RestaurantesModel> obtenerTodosRestaurantes();
    RestaurantesModel obtenerRestaurantePorId(Long id);
    RestaurantesModel crearRestaurante(RestaurantesModel r);
    RestaurantesModel actualizarRestaurante(Long id, RestaurantesModel r);
    RestaurantesModel eliminarRestaurante(Long id);
}
