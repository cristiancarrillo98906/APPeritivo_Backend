package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.ReservationModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
@Service
public class ReservationService implements IReservationService {

    private static final String FILE_PATH = "reserva.json";
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public ArrayList<ReservationModel> obtenerTodasReservas() {
        ArrayList<ReservationModel> reservas = new ArrayList<>();
        try {
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            reservas = objectMapper.readValue(archivo, new
                    TypeReference<ArrayList<ReservationModel>>() {
                    });
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return reservas;
    }

    @Override
    public ReservationModel obtenerReservaPorId(Long id) {
        ArrayList<ReservationModel> reservas = this.obtenerTodasReservas();
        for (ReservationModel r : reservas) {
            if (r.getIdReserva() == id) {
                return r;
            }
        }
        return new ReservationModel();

    }

    @Override
    public ReservationModel crearReserva(ReservationModel r) {
        ArrayList<ReservationModel> reservas = this.obtenerTodasReservas();
        //Crear el ID
        Long id = 1L; //int id = 1;
        if(!reservas.isEmpty()){
            id =reservas.get(reservas.size()-1).getIdReserva() + 1;
        }
        r.setIdReserva(id);
        //Array de Productos (añadir el producto)
        reservas.add(r);
        //Guardar el JSON (mapear el arrayList en un JSON)
        try{
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            objectMapper.writeValue(archivo,reservas);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return r;
    }

    @Override
    public ReservationModel actualizarReserva(Long id, ReservationModel r) {
        //Producto productoEncontrado = obtenerProductoPorId(id);
        ArrayList<ReservationModel> reservas = this.obtenerTodasReservas();
        ReservationModel reservaEncontrado=null;
        for (ReservationModel resev : reservas){
            if (resev.getIdReserva()==id){
                //Actualizo el ARRAY de productos
                resev.setIdUsuario(r.getIdUsuario());
                resev.setIdRestaurante(r.getIdRestaurante());
                resev.setFecha(r.getFecha());
                resev.setNumPer(r.getNumPer());
                reservaEncontrado=resev;
                break;
            }
        }

        if (reservaEncontrado !=null && reservaEncontrado.getIdReserva()==id){
            //Guardamos en el JSON
            try{
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo,reservas);
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return reservaEncontrado;
    }

    @Override
    public ReservationModel eliminarReserva(Long id) {
        ArrayList<ReservationModel> reservas = obtenerTodasReservas();
        ReservationModel reservasEliminado = null;
        for (ReservationModel resev : reservas){
            if(resev.getIdReserva()== id){
                reservasEliminado=resev;
                reservas.remove(resev);
                break;
            }
        }
        if (reservasEliminado != null && reservasEliminado.getIdReserva() == id){
            //Guardamos en el JSON
            try{
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo,reservas);
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return reservasEliminado;
    }
}


