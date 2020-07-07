/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.service;

import com.sharemy10.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sharemy10.domain.*;
import java.util.List;
/**
 *
 * @author HP PC
 */

@Service
public class MateriaService {
    
    @Autowired
    MateriaRepository matRepo;
    
    public List<Materia> findAll(){
        return matRepo.findAll();
    }
    
    public List<Materia> findAllCarrera(String carrera){
        return matRepo.findAllByCarrera(carrera);
    }
    
    public Materia findById(Integer id){
        return matRepo.findById(id).get();
    }
    
    public Materia save(Materia materia){
        return matRepo.save(materia);
    }
    
    public void delete(Materia materia){
        matRepo.delete(materia);
    }
    
}
