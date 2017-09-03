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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.web.servlet.view.groovy.GroovyMarkupConfigurer;

/**
 *
 * @author S
 */
@Entity
@Table(name="Caracteristicas")
public class Feature {
    @Id
    @GeneratedValue
    @Column(name="id_Caracteristica",nullable=false,unique=true)
    private int id_caracteristica;
    
    @Column(name="nombre")
    private String name;
    
    @Column(name="isRoot")
    private boolean isroot;
    
    @OneToOne
    @JoinColumn(name="post",nullable = true)
    private Feature prev;
    
    @OneToOne
    @JoinColumn(name="prev",nullable = true)
    private Feature post;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Documento",nullable = false)
    private Document document;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="feature")
    private Set<Property> properties = new HashSet<Property>();
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="id_Feature")
    private Set<Incompatibility> incompatibilities = new HashSet<Incompatibility>();
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="id_Feature")
    private Set<Requirement> requirements = new HashSet<Requirement>();
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="origin")
    private Set<DirectRelation> directRelations = new HashSet<DirectRelation>();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="feature")
    private Set<GroupRelation> groupRelations = new HashSet<GroupRelation>();
    
    
    public Feature(){}

    public Feature(int id_caracteristica, String name, boolean isroot, Feature prev, Feature post, Document document) {
        this.id_caracteristica = id_caracteristica;
        this.name = name;
        this.isroot = isroot;
        this.prev = prev;
        this.post = post;
        this.document = document;
    }
    
    public int getId_caracteristica() {
        return id_caracteristica;
    }

    public void setId_caracteristica(int id_caracteristica) {
        this.id_caracteristica = id_caracteristica;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsRoot() {
        return isroot;
    }

    public void setIsRoot(boolean isroot) {
        this.isroot = isroot;
    }

    public Feature getPrev() {
        return prev;
    }

    public void setPrev(Feature prev) {
        this.prev = prev;
    }

    public Feature getPost() {
        return post;
    }

    public void setPost(Feature post) {
        this.post = post;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public void setProperties(Set<Property> properties) {
        this.properties = properties;
    }

    public Set<Incompatibility> getIncompatibilities() {
        return incompatibilities;
    }

    public void setIncompatibilities(Set<Incompatibility> incompatibilities) {
        this.incompatibilities = incompatibilities;
    }

    public Set<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(Set<Requirement> requirements) {
        this.requirements = requirements;
    }

    public Set<DirectRelation> getDirectRelations() {
        return directRelations;
    }

    public void setDirectRelations(Set<DirectRelation> directRelations) {
        this.directRelations = directRelations;
    }

    public Set<GroupRelation> getGroupRelations() {
        return groupRelations;
    }

    public void setGroupRelations(Set<GroupRelation> groupRelations) {
        this.groupRelations = groupRelations;
    }
    
    
}
