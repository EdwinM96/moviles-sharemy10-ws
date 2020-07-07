/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.controller;

import com.sharemy10.service.UsuarioService;
import com.sharemy10.domain.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP PC
 */

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioService uService;
    
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<?> saveUsuario(@RequestParam("usuario") String username, @RequestParam("email") String email,
             @RequestParam("password") String pass, @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido,
             @RequestParam(value= "imagenDePerfil", required = false) MultipartFile imagen, HttpServletRequest request, HttpServletResponse response) throws IOException{
        if(uService.usernameIsAvailable(username)){
            return new ResponseEntity("Username is not available", HttpStatus.NOT_ACCEPTABLE);
        }
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPass(pass);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        if(imagen!=null){
            Byte[] imageBytes = new Byte[imagen.getBytes().length];
                for (int i = 0; i < imagen.getBytes().length; i++)
                {
                    imageBytes[i] = imagen.getBytes()[i];
                }
            usuario.setImagen_de_perfil(imageBytes);
        }
        usuario.setUsuario(username);
        uService.save(usuario);
        return new ResponseEntity("User created", HttpStatus.OK);
    }
    
    
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> logearUsuario(@RequestParam("usuario") String username, @RequestParam("password") String password){
        Usuario usuario = new Usuario();
        usuario.setUsuario(username);
        usuario.setPass(password);
        if(uService.findByUsernameAndPassword(usuario)!=null){
            return new ResponseEntity("Authentication success", HttpStatus.OK);
        }
        return new ResponseEntity("Authentication failed", HttpStatus.UNAUTHORIZED);
    }
}
