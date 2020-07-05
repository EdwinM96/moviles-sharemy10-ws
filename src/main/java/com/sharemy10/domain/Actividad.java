/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sharemy10.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HP PC
 */

@Entity
@Table(name = "actividad", schema = "public")
public class Actividad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="actividad_id")
    Integer actividadId;
    
    @Column(name="nombre")
    String nombre;
    
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_de_evaluacion")
    Date fechaDeEvaluacion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="materia_id")
    Integer materiaId;
    
    @Column(name="tipo_de_actividad")
    String tipoDeActividad;

    public Integer getActividadId() {
        return actividadId;
    }

    public void setActividadId(Integer actividadId) {
        this.actividadId = actividadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDeEvaluacion() {
        return fechaDeEvaluacion;
    }

    public void setFechaDeEvaluacion(Date fechaDeEvaluacion) {
        this.fechaDeEvaluacion = fechaDeEvaluacion;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public String getTipoDeActividad() {
        return tipoDeActividad;
    }

    public void setTipoDeActividad(String tipoDeActividad) {
        this.tipoDeActividad = tipoDeActividad;
    }
    
    
    
}
