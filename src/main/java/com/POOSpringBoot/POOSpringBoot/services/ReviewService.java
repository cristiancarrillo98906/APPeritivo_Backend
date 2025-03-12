package com.POOSpringBoot.POOSpringBoot.services;


import com.POOSpringBoot.POOSpringBoot.models.ReviewModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Service
public class ReviewService implements IReviewService{
    private static final String FILE_PATH = "review.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Obtener todos los productos
    @Override
    public ArrayList<ReviewModel> obtenerTodasReseñas() {
        ArrayList<ReviewModel> reseñas = new ArrayList<>();
        try {
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            reseñas = objectMapper.readValue(archivo, new
                    TypeReference<ArrayList<ReviewModel>>(){});
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return reseñas;
    }

    @Override
    public ReviewModel obtenerReseñaPorId(Long id) {
        ArrayList<ReviewModel> reseñas = this.obtenerTodasReseñas();
        for(ReviewModel p:reseñas){
            if(p.getIdReview() == id){
                return p;
            }
        }
        return new ReviewModel();
    }

    @Override
    public ReviewModel crearReseña(ReviewModel r) {
        ArrayList<ReviewModel> reseñas = this.obtenerTodasReseñas();
        //Crear el ID
        Long id = 1L; //int id = 1;
        if(!reseñas.isEmpty()){
            id =reseñas.get(reseñas.size()-1).getIdReview() + 1;
        }
        r.setIdReview(id);
        //Array de Productos (añadir el producto)
        reseñas.add(r);
        //Guardar el JSON (mapear el arrayList en un JSON)
        try{
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            objectMapper.writeValue(archivo,reseñas);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return r;
    }

    @Override
    public ReviewModel actualizarReseña(Long id, ReviewModel r) {
        //Producto productoEncontrado = obtenerProductoPorId(id);
        ArrayList<ReviewModel> reseñas = this.obtenerTodasReseñas();
        ReviewModel reseñaEncontrado=null;
        for (ReviewModel prod : reseñas){
            if (prod.getIdReview()==id){
                //Actualizo el ARRAY de productos
                prod.setComentario(r.getComentario());
                prod.setFecha(r.getFecha());
                prod.setIdRestaurante(r.getIdRestaurante());
                prod.setIdUsuario(r.getIdUsuario());
                prod.setValoracion(r.getValoracion());
                reseñaEncontrado=prod;
                break;
            }
        }

        if (reseñaEncontrado !=null && reseñaEncontrado.getIdReview()==id){
            //Guardamos en el JSON
            try{
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo,reseñas);
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return reseñaEncontrado;
    }

    @Override
    public ReviewModel eliminarReseña(Long id) {
        ArrayList<ReviewModel> reseñas = obtenerTodasReseñas();
        ReviewModel reseñasEliminado = null;
        for (ReviewModel prod : reseñas){
            if(prod.getIdReview()== id){
                reseñasEliminado=prod;
                reseñas.remove(prod);
                break;
            }
        }
        if (reseñasEliminado != null && reseñasEliminado.getIdReview() == id){
            //Guardamos en el JSON
            try{
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo,reseñas);
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return reseñasEliminado;
    }
}

