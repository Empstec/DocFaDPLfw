/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
    private Feature id_Feature;
    
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Caracteristica",nullable = false)
    private Feature incompatible;
    
    @Column(name="tipo")
    private String type;
    
    public Incompatibility(){}

    public Incompatibility(Feature id_Feature, Feature incompatible, String type) {
        this.id_Feature = id_Feature;
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
        return id_Feature;
    }

    public void setId_feature(Feature id_Feature) {
        this.id_Feature = id_Feature;
    }

    public Feature getIncompatible() {
        return incompatible;
    }

    public void setIncompatible(Feature incompatible) {
        this.incompatible = incompatible;
    }
}
