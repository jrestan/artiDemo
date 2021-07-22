package com.example.artiDemo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.artiDemo.models.UsuarioModel;
import com.example.artiDemo.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        //Ejemplo: http://localhost:8080/usuario
        //Se ejecuta desde la raiz
        //Se puede ejecutar desde un navegador
        //Tambien se puede ejecutar desde el postman pero setear el GET
        //Simplemente traera a todos los usuarios
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        //Ejemplo: http://localhost:8080/usuario
        //Se ejecuta desde la raiz
        //Se debe ejecutar desde el postman Y setear el POST
        //Simplemente traera a todos los usuarios
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        //Ejemplo: http://localhost:8080/usuario/3
        //Se puede ejecutar desde un navegador
        //Buscara al usuario que tiene el id 3
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuariosPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        //Ejemplo: http://localhost:8080/usuario/query?prioridad=5
        //Se puede ejecutar desde un navegador
        //Buscara a todos los usuarios que tienen prioridad 5
        return usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        //Ejemplo: http://localhost:8080/usuario/5
        //Se debe ejecutar desde el postman Y setear el DELETE
        //Eliminara al usuario que tiene el id 5
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se elimino el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id " + id;
        }
    }


}
