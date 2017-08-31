/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author S
 */
@Entity
@Table(name="Propiedades")
public class Property {
    @Id
    @GeneratedValue
    @Column(name="id_Propiedad",nullable=false,unique=true)
    private int id_propiedad;
    
    @Column(name="nombre")
    private String name;
    
    @Column(name="tipo")
    private String type;
    
    @ManyToMany(fetch = FetchType.LAZY,mappedBy="properties")
    private Set<Content> contents = new HashSet<Content>();
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Caracteristica",nullable = false)
    private Feature feature;
    
    public Property(){}

    public Property(int id_propiedad, String name, String type, Feature feature) {
        this.id_propiedad = id_propiedad;
        this.name = name;
        this.type = type;
        this.feature = feature;
    }
    
    public Property(int id_propiedad, String name, String type, Feature feature,Set<Content> contents) {
        this.id_propiedad = id_propiedad;
        this.name = name;
        this.type = type;
        this.feature = feature;
        this.contents = contents;
    }

    public int getId_propiedad() {
        return id_propiedad;
    }

    public void setId_propiedad(int id_propiedad) {
        this.id_propiedad = id_propiedad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
