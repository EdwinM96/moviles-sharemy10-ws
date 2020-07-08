/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.controller;

import com.sharemy10.service.ActividadService;
import com.sharemy10.service.ComentarioService;
import com.sharemy10.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP PC
 */

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    
    @Autowired
    ComentarioService cService;
    
    @Autowired
    ActividadService aService;
    
    @Autowired
    UsuarioService uService;
    
     @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllComentariosByActividad(@RequestParam("actividadId") Integer actividadId, HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity(cService.findAllByActividad(aService.findOne(actividadId)), HttpStatus.OK);
    }
    
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveComentario(@RequestParam("actividadId") Integer actividadId, @RequestParam("comentario") String comentario,
            @RequestParam("username") String username, @RequestParam("password") String password,
            HttpServletRequest request, HttpServletResponse response){
        
        
        return new ResponseEntity(cService.findAllByActividad(aService.findOne(actividadId)), HttpStatus.OK);
    }
    
}
