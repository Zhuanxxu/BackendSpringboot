/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javainuse.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Agustín
 */
@Getter @Setter
@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

   
   
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    
    @Basic
    private LocalDate fechaNac;
    //la fecha que viene es AAAA/MM/DD
    private String correo;
    
    @ManyToOne()
    @JoinColumn()
    private Domicilio domicilio;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Educacion> educacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Proyecto> proyectos;
    
    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, LocalDate fechaNac, String correo, Domicilio domicilio, List<Educacion> educacion, List<Proyecto> proyectos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.correo = correo;
        this.domicilio = domicilio;
        this.educacion = educacion;
        this.proyectos = proyectos;
    }

    

    

    
}
