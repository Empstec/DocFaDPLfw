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
@Table(name="permisos")
/*@AssociationOverrides({
    @AssociationOverride(name = "pk.user",joinColumns = @JoinColumn(name = "id_Usuario")),
    @AssociationOverride(name = "pk.docuemnt",joinColumns = @JoinColumn(name = "id_Documento")) })*/
public class Permission implements Serializable{
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Documento",nullable = false)
    private Document document;
    
    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Usuario",nullable = false)
    private User user;
    
    @Column(name="permisos")
    private String permissions;
    
    public Permission(){}

    public Permission(Document document, User user, String permissions) {
        this.document = document;
        this.user = user;
        this.permissions = permissions;
    }
    
    public void setPermissions(String permissions){
        this.permissions = permissions;
    }
    
    
    public String getPermissions(){
        return this.permissions;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
