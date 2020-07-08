/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.controller;

import com.sharemy10.service.MateriaService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP PC
 */

@RestController
@RequestMapping("/materia")
public class MateriaController {
    
    @Autowired
    MateriaService mService;
    
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllMaterias(HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity(mService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/carrera", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllMateriasByCarrera(@RequestParam("carrera") String carrera, HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity(mService.findAllCarrera(carrera), HttpStatus.OK);
    }
    
}
