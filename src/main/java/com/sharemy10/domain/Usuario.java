/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HP PC
 */

@Entity
@Table(name="usuario", schema="public")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="usuario_id")
    Integer usuarioId;
    
    @Column(name="usuario")
    String usuario;
    
    @Column(name="pass")
    String pass;
    
    @Column(name="pass_salt")
    String pass_salt;
    
    @Column(name="imagen_de_perfil")
    Byte[] imagen_de_perfil;
    
    @Column(name="email")
    String email;
    
    @Column(name="apellido")
    String apellido;
    
    @Column(name="nombre")
    String nombre;
    
    @Column(name="contribuciones")
    Integer contribuciones;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass_salt() {
        return pass_salt;
    }

    public void setPass_salt(String pass_salt) {
        this.pass_salt = pass_salt;
    }

    public Byte[] getImagen_de_perfil() {
        return imagen_de_perfil;
    }

    public void setImagen_de_perfil(Byte[] imagen_de_perfil) {
        this.imagen_de_perfil = imagen_de_perfil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getContribuciones() {
        return contribuciones;
    }

    public void setContribuciones(Integer contribuciones) {
        this.contribuciones = contribuciones;
    }
    
    
    
}
