/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sharemy10.domain.*;
import java.util.List;
/**
 *
 * @author HP PC
 */

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {
    
    public List<Materia> findAllByCarrera(String carrera);
    
}
