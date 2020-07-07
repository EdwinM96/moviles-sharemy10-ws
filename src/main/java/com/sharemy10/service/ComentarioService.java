/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.service;

import com.sharemy10.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sharemy10.domain.*;
import com.sharemy10.repository.UsuarioRepository;
import java.util.List;
import com.sharemy10.domain.*;
import javax.transaction.Transactional;
/**
 *
 * @author HP PC
 */

@Service
public class ComentarioService {
    
    @Autowired
    ComentarioRepository comRepo;
    
    @Autowired
    UsuarioRepository usuarioRepo;
    
    public List<Comentario> findAll(){
        return comRepo.findAll();
    }
    
    public List<Comentario> findAllByActividad(Actividad actividad){
        return comRepo.findByActividad(actividad);
    }
    
    @Transactional
    public Comentario saveComentario(Comentario comentario){
        Usuario usuario = usuarioRepo.findById(comentario.getUsuario().getUsuarioId()).get();
        usuario.setContribuciones(usuario.getContribuciones()+1);
        usuarioRepo.save(usuario);
        return comRepo.saveAndFlush(comentario);
    }
    
    @Transactional
    public void deleteComentario(Comentario comentario){      
        Usuario usuario = usuarioRepo.findById(comentario.getUsuario().getUsuarioId()).get();
        usuario.setContribuciones(usuario.getContribuciones()-1);
        usuarioRepo.save(usuario);
        comRepo.delete(comentario);
    }
}
