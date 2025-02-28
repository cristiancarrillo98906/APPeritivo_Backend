package com.POOSpringBoot.POOSpringBoot.services;

import com.POOSpringBoot.POOSpringBoot.models.UserModel;
import org.apache.catalina.User;

import java.util.ArrayList;

public interface IUserService {
    ArrayList<UserModel> obtenerTodosUsuarios();
    UserModel obtenerUsuarioPorId(Long id);
    UserModel crearUsuario(UserModel u);
    UserModel actualizarUsuario(Long id, UserModel u);
    UserModel eliminarUsuario(Long id);
}
