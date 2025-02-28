package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

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
        return u;
    }

    @Override
    public UserModel actualizarUsuario(Long id, UserModel u) {
        ArrayList<UserModel> userModels = obtenerTodosUsuarios();
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
        ArrayList<UserModel> userModels = obtenerTodosUsuarios();
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
