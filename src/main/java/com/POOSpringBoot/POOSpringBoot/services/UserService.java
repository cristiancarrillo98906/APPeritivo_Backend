package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService implements IUserService{
    private static final String FILE_PATH = "usuarios.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    //Obtener los usuarios
    @Override
    public ArrayList<UserModel> obtenerTodosUsuarios() {
        ArrayList<UserModel> userModels = new ArrayList<>();
        try {
            File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
            userModels = objectMapper.readValue(archivo, new
                    TypeReference<ArrayList<UserModel>>(){});
        } catch (IOException | URISyntaxException e){
            throw new RuntimeException(e);
        }
        return userModels;
    }

    //Obtener los usuarios por un id
    @Override
    public UserModel obtenerUsuarioPorId(Long id) {
        ArrayList<UserModel> userModels = this.obtenerTodosUsuarios();
        for (UserModel u: userModels){
            if (u.getId() == id){
                return u;
            }
        }
        return new UserModel();
    }

    @Override
    public UserModel crearUsuario(UserModel u) {
        ArrayList<UserModel> userModels = this.obtenerTodosUsuarios();

        for (UserModel user: userModels){
            if (u.getUsername().equalsIgnoreCase(user.getUsername())){
                System.out.println("El usuario ingresado ya existe, por favor intenta con otro usuario");
                return null;
            }
        }

        if (u.getPassword().length() > 8){
            boolean mayuscula = false;
            boolean numero = false;
            boolean letraOsimbolo = false;
            boolean especial = false;

            Pattern special = Pattern.compile("[?!¡@¿.,´)]");
            Matcher hasSpecial = special.matcher(u.getPassword());
            char l;

            for(int i = 0; i < u.getPassword().length(); i++){
                l = u.getPassword().charAt(i);

                if (Character.isDigit(l)){
                    numero = true;
                }
                if (Character.isLetter(l)){
                    letraOsimbolo = true;
                }
                if (Character.isUpperCase(l)){
                    mayuscula = true;
                }
                if (hasSpecial.find()){
                    especial = true;
                }
            }
            if (numero == true && mayuscula == true && letraOsimbolo == true && especial == true){
                //Crear el id
                Long id = 1L;
                if (!userModels.isEmpty()){
                    id = userModels.get(userModels.size() - 1).getId() + 1;
                }
                u.setId(id);
                userModels.add(u);
                try {
                    File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                    objectMapper.writeValue(archivo,userModels);
                } catch (IOException | URISyntaxException e){
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("La contraseña no cumple con lo mínimo requerido");
            }
        } else {
            System.out.println("La contraseña no cumple con lo mínimo requerido");
        }
        return u;
    }

    @Override
    public UserModel actualizarUsuario(Long id, UserModel u) {
        ArrayList<UserModel> userModels = this.obtenerTodosUsuarios();
        UserModel usuarioEncontrado = null;
        for (UserModel user: userModels){
            if (user.getId() == id){
                user.setUsername(u.getUsername());
                user.setName(u.getName());
                user.setLastname(u.getLastname());
                user.setEmail(u.getEmail());
                user.setPassword(u.getPassword());
                user.setProfile(u.getProfile());
                usuarioEncontrado = user;
                break;
            }
        }
        if (usuarioEncontrado != null && usuarioEncontrado.getId() == id){
            try {
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo,userModels);
            } catch (IOException | URISyntaxException e){
                throw new RuntimeException(e);
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public UserModel eliminarUsuario(Long id) {
        ArrayList<UserModel> userModels = this.obtenerTodosUsuarios();
        UserModel usuarioEliminado = null;

        for (UserModel user: userModels){
            if (user.getId() == id){
                userModels.remove(user);
                usuarioEliminado = user;
                break;
            }
        }

        if (usuarioEliminado != null && usuarioEliminado.getId() == id){
            try {
                File archivo = new File(getClass().getClassLoader().getResource(FILE_PATH).toURI());
                objectMapper.writeValue(archivo,userModels);
            } catch (IOException | URISyntaxException e){
                throw new RuntimeException(e);
            }
        }
        return usuarioEliminado;
    }
}
