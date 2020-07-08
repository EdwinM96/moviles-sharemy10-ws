/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.repository;

import org.springframework.stereotype.Repository;
import com.sharemy10.domain.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author HP PC
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    public Usuario findOneByUsuarioAndPass(String usuario, String pass);
    
    public Usuario findOneByUsuario(String usuario);
    
    public Usuario findOneByEmail(String email);
    
}
