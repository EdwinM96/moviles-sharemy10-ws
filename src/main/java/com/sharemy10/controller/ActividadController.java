/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.controller;

import com.sharemy10.service.ActividadService;
import com.sharemy10.service.MateriaService;
import com.sharemy10.domain.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author HP PC
 */

@Controller
@RequestMapping("/actividad")
public class ActividadController {
    
    @Autowired
    ActividadService actiService;
    
    @Autowired
    MateriaService materiaService;
    
    /*
    @RequestMapping(name = "/", produces = MediaType.APPLICATION_JSON_VALUE , headers = "Accept=application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> findAllActividades(HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity<>(actiService.findAll(), HttpStatus.OK);
    }
    */
    
    
    @RequestMapping(name = "/", produces = MediaType.APPLICATION_JSON_VALUE , headers = "Accept=application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> findAllActividadesByMateria(@RequestParam("materiaId") Integer materiaId, HttpServletRequest request, HttpServletResponse response){
        Materia materia = materiaService.findById(materiaId);
        return new ResponseEntity(actiService.findAllByMateria(materia), HttpStatus.OK);
    }
    
    
}
