/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author S
 */
@Entity
@Table(name="grupo_relaciones")
public class GroupRelation implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id_Relacion")
    private int id_Grupo;
    
    @Column(name="mult_min")
    private int mult_min;
    
    @Column(name="mult_max")
    private int mult_max;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Caracteristica",nullable = false)
    private Feature feature;
    
    @OneToMany(fetch =FetchType.EAGER,mappedBy="group")
    private Set<DirectRelation> directRelations = new HashSet<DirectRelation>(); 
    
    public GroupRelation(){}

    public GroupRelation(int id_Grupo, int mult_min, int mult_max, Feature feature) {
        this.id_Grupo = id_Grupo;
        this.mult_min = mult_min;
        this.mult_max = mult_max;
        this.feature = feature;
    }

    public int getId_Grupo() {
        return id_Grupo;
    }

    public void setId_Grupo(int id_Grupo) {
        this.id_Grupo = id_Grupo;
    }

    public int getMult_min() {
        return mult_min;
    }

    public void setMult_min(int mult_min) {
        this.mult_min = mult_min;
    }

    public int getMult_max() {
        return mult_max;
    }

    public void setMult_max(int mult_max) {
        this.mult_max = mult_max;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Set<DirectRelation> getDirectRelations() {
        return directRelations;
    }

    public void setDirectRelations(Set<DirectRelation> directRelations) {
        this.directRelations = directRelations;
    }
}
