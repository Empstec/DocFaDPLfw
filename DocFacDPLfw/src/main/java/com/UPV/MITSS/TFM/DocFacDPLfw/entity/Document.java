/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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
@Table(name="Documentos")
public class Document implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="id_Documento",nullable=false,unique=true)
    private int id_documento;
    
    @Column(name="titulo")
    private String title;
    
    @Column(name="descripcion")
    private String description;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="autor",nullable = false)
    private User author;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="document",cascade = CascadeType.ALL)
    private Set<Permission> permissions = new HashSet<Permission>();
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="document")
    private Set<Feature> features = new HashSet<Feature>();
    
    public Document(){};

    public Document(int id_documento, String title, String description, User author) {
        this.id_documento = id_documento;
        this.title = title;
        this.description = description;
        this.author = author;
    }
    
    public Document(int id_documento, String title, String description, User author,Set<Permission> permissions, Set<Feature> features) {
        this.id_documento = id_documento;
        this.title = title;
        this.description = description;
        this.author = author;
        this.permissions = permissions;
        this.features = features;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }
}
