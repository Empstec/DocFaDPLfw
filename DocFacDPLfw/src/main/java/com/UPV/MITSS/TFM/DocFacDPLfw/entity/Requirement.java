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
@Table(name="requerimientos")
/*@AssociationOverrides({
    @AssociationOverride(name = "pk.id_Feature",joinColumns = @JoinColumn(name = "id_Caracteristica")),
    @AssociationOverride(name = "pk.required",joinColumns = @JoinColumn(name = "id_Caracteristica")) })*/
public class Requirement implements Serializable{
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Caracteristica",nullable = false)
    private Feature id_feature; // Callar
    
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="requerida",nullable = false)
    private Feature requiered; // Destiny
    
    @Column(name="tipo")
    private String type; // Type of requirement {Mandatory, Optional}
    
    public Requirement(){}

    public Requirement(Feature id_feature, Feature requiered, String type) {
        this.id_feature = id_feature;
        this.requiered = requiered;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }  

    public Feature getId_Feature() {
        return id_feature;
    }

    public void setId_Feature(Feature id_feature) {
        this.id_feature = id_feature;
    }

    public Feature getRequiered() {
        return requiered;
    }

    public void setRequiered(Feature requiered) {
        this.requiered = requiered;
    }
}
