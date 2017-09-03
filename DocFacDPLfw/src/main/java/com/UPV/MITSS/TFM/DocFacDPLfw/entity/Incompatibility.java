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
@Table(name="incompatibilidades")
/*@AssociationOverrides({
    @AssociationOverride(name = "pk.id_Feature",joinColumns = @JoinColumn(name = "id_Caracteristica")),
    @AssociationOverride(name = "pk.incompatible",joinColumns = @JoinColumn(name = "id_Caracteristica")) })*/
public class Incompatibility implements Serializable{
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Caracteristica",nullable = false)
    private Feature id_feature;
    
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="incompatible",nullable = false)
    private Feature incompatible;
    
    @Column(name="tipo")
    private String type;
    
    public Incompatibility(){}

    public Incompatibility(Feature id_feature, Feature incompatible, String type) {
        this.id_feature = id_feature;
        this.incompatible = incompatible;
        this.type = type;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Feature getId_feature() {
        return id_feature;
    }

    public void setId_feature(Feature id_feature) {
        this.id_feature = id_feature;
    }

    public Feature getIncompatible() {
        return incompatible;
    }

    public void setIncompatible(Feature incompatible) {
        this.incompatible = incompatible;
    }
}
