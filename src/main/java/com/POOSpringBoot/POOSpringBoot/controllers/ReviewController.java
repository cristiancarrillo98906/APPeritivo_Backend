package com.POOSpringBoot.POOSpringBoot.controllers;

import com.POOSpringBoot.POOSpringBoot.models.ReviewModel;
import com.POOSpringBoot.POOSpringBoot.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/resena")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping
    public ArrayList<ReviewModel> obtenerTodos() {
        return reviewService.obtenerTodasReseñas();
    }
    @GetMapping("/{id}")
    public ReviewModel obtenerProducto(@PathVariable Long id){
        return reviewService.obtenerReseñaPorId(id);
    }
    @PostMapping
    public ReviewModel newProducto(@RequestBody ReviewModel p){
        return reviewService.crearReseña(p);
    }
    @PutMapping("/{id}")
    public ReviewModel updateProducto(@PathVariable Long id, @RequestBody ReviewModel p){
        return  reviewService.actualizarReseña(id, p);
    }
    @DeleteMapping("/{id}")
    public ReviewModel deleteProducto(@PathVariable Long id){
        return reviewService.eliminarReseña(id);
    }

}

