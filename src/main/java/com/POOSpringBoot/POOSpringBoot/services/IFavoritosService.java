package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.FavoritosModel;

import java.util.ArrayList;

public interface IFavoritosService {
    ArrayList<FavoritosModel> obtenerTodosFavoritos();
    FavoritosModel obtenerFavoritoPorId(Long id);
    FavoritosModel crearFavorito(FavoritosModel f);
    FavoritosModel actualizarFavorito(Long id, FavoritosModel f);
    FavoritosModel eliminarFavorito(Long id);
}
