package com.POOSpringBoot.POOSpringBoot.controllers;

import com.POOSpringBoot.POOSpringBoot.models.ReservationModel;
import com.POOSpringBoot.POOSpringBoot.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/reserva")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping
    public ArrayList<ReservationModel> obtenerTodos() {
        return reservationService.obtenerTodasReservas();
    }
    @GetMapping("/{id}")
    public ReservationModel obtenerProducto(@PathVariable Long id){
        return reservationService.obtenerReservaPorId(id);
    }
    @PostMapping
    public ReservationModel newProducto(@RequestBody ReservationModel r){
        return reservationService.crearReserva(r);
    }
    @PutMapping("/{id}")
    public ReservationModel updateProducto(@PathVariable Long id, @RequestBody ReservationModel r){
        return  reservationService.actualizarReserva(id, r);
    }
    @DeleteMapping("/{id}")
    public ReservationModel deleteProducto(@PathVariable Long id){
        return reservationService.eliminarReserva(id);
    }

}