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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author S
 */
@Entity
@Table(name="Caracteristicas")
public class Feature {
    @Id
    @GeneratedValue
    @Column(name="id_Catracteristica",nullable=false,unique=true)
    private int id_caracterisctica;
    
    @Column(name="nombre")
    private String name;
    
    @Column(name="isRoot")
    private boolean isRoot;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Documento",nullable = false)
    private Document document;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="feature")
    private Set<Property> properties = new HashSet<Property>();
    
    public Feature(){}
}
