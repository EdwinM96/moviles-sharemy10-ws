/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.service;

import com.sharemy10.repository.ActividadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sharemy10.domain.*;

/**
 *
 * @author HP PC
 */

@Service
public class ActividadService {
    
    @Autowired
    ActividadRepository actiRepo;
    
    public List<Actividad> findAll(){
        return actiRepo.findAll();
    }
    
    public List<Actividad> findAllByMateria(Materia materia){
        return actiRepo.findByMateria(materia);
    }
    
    public Actividad saveActividad(Actividad actividad){
        return actiRepo.saveAndFlush(actividad);
    }
    
    public void deleteActividad(Actividad actividad){
        actiRepo.delete(actividad);
    }
}
