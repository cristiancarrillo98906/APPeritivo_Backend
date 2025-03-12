package com.POOSpringBoot.POOSpringBoot.services;


import com.POOSpringBoot.POOSpringBoot.models.ReviewModel;

import java.util.ArrayList;

public interface IReviewService {
    ArrayList<ReviewModel> obtenerTodasReseñas();
    ReviewModel obtenerReseñaPorId(Long id);
    ReviewModel crearReseña(ReviewModel p);
    ReviewModel actualizarReseña(Long id, ReviewModel p);
    ReviewModel eliminarReseña(Long id);
}
