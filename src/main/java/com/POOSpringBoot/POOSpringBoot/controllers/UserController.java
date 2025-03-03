package com.POOSpringBoot.POOSpringBoot.controllers;

import com.POOSpringBoot.POOSpringBoot.models.UserModel;
import com.POOSpringBoot.POOSpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> obtenerTodos(){
        return userService.obtenerTodosUsuarios();
    }

    @GetMapping("/{id}")
    public UserModel obtenerUsuario(@PathVariable Long id){
        return userService.obtenerUsuarioPorId(id);
    }

    @PostMapping
    public UserModel newUsuario(@RequestBody UserModel u){
        return userService.crearUsuario(u);
    }

    @PutMapping("/{id}")
    public UserModel updateUsuario(@PathVariable Long id, @RequestBody UserModel u){
        return userService.actualizarUsuario(id, u);
    }

    @DeleteMapping("/{id}")
    public UserModel deleteUsuario(@PathVariable Long id){
        return userService.eliminarUsuario(id);
    }

}
