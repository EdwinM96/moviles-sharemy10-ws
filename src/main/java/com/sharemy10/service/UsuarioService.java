/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.service;

import com.sharemy10.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import com.sharemy10.domain.*;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author HP PC
 */

@Service
public class UsuarioService implements UserDetailsService {
    
    @Autowired
    UsuarioRepository usRepo;
    
    public List<Usuario> findAll(Usuario usuario){
        return usRepo.findAll();
    }
    
    public Usuario findByUsernameAndPassword(Usuario usuario){
        return usRepo.findOneByUsuarioAndPass(usuario.getUsuario(), usuario.getPass());
    }

    public void delete(Usuario usuario){
        usRepo.delete(usuario);
    }
    
    public Usuario save(Usuario usuario){
        return usRepo.save(usuario);
    }
    
    public boolean usernameIsAvailable(String username){
        return (usRepo.findOneByUsuario(username)!=null);
    }

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario user = usRepo.findOneByUsuario(usuario);
        if(user == null){
            throw new UsernameNotFoundException(usuario);
        }
        return User.withUsername(user.getUsuario()).password(user.getPass()).roles("USER").build();
    }
    
}
