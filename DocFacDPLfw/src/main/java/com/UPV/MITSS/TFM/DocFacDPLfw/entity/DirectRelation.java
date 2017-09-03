/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author S
 */
@Entity
@Table(name="Relaciones_Directas")
public class DirectRelation implements Serializable{
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Caracteristica_Origen",nullable = false)
    private Feature origin;
    
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Caracteristica_Destino",nullable = false)
    private Feature destiny;
    
    @Column(name="mult_max")
    private int mult_max;

    @Column(name="mult_min")
    private int mult_min;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Grupo",nullable = true)
    private GroupRelation group;

    public DirectRelation(){}

    public DirectRelation(Feature origin, Feature destiny, int mult_max, int mult_min, GroupRelation group) {
        this.origin = origin;
        this.destiny = destiny;
        this.mult_max = mult_max;
        this.mult_min = mult_min;
        this.group = group;
    }
    
    public int getMult_max() {
        return mult_max;
    }

    public void setMult_max(int mult_max) {
        this.mult_max = mult_max;
    }

    public int getMult_min() {
        return mult_min;
    }

    public void setMult_min(int mult_min) {
        this.mult_min = mult_min;
    }

    public GroupRelation getGroup() {
        return group;
    }

    public void setGroup(GroupRelation group) {
        this.group = group;
    }
    
    public Feature getOrigin() {
        return origin;
    }

    public void setOrigin(Feature origin) {
        this.origin = origin;
    }

    public Feature getDestiny() {
        return destiny;
    }

    public void setDestiny(Feature destiny) {
        this.destiny = destiny;
    }
}
