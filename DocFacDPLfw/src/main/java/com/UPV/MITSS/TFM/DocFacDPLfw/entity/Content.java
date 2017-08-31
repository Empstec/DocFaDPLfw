/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author S
 */
@Entity
@Table(name="Contenidos")
public class Content {
    @Id
    @GeneratedValue
    @Column(name="id_Contenido",nullable=false,unique=true)
    private int id_contenido;
    
    @Column(name="tipo_Propiedad")
    private String typeProperty;
    
    @Column(name="contenido")
    private String content;
    
    @Column(name="tipo")
    private String type;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Usuario",nullable = false)
    private User user;
    
    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="contents")
    @JoinTable(name = "Contenidos_Propiedades", joinColumns = {@JoinColumn(name = "id_Contenido", nullable=false, updatable=false)}, inverseJoinColumns = {@JoinColumn(name = "id_Propiedad", nullable=false, updatable=false)})
    private Set<Property> properties = new HashSet<Property>();
    
    public Content(){}

    public Content(int id_contenido, String typeProperty, String content, String type, User user, Set<Property> properties) {
        this.id_contenido = id_contenido;
        this.typeProperty = typeProperty;
        this.content = content;
        this.type = type;
        this.user = user;
        this.properties = properties;
    }

    public Content(int id_contenido, String typeProperty, String content, String type, User user) {
        this.id_contenido = id_contenido;
        this.typeProperty = typeProperty;
        this.content = content;
        this.type = type;
        this.user = user;
    }

    public int getId_contenido() {
        return id_contenido;
    }

    public void setId_contenido(int id_contenido) {
        this.id_contenido = id_contenido;
    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }
}
