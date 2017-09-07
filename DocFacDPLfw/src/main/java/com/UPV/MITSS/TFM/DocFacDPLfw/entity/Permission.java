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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author S
 */
@Entity
@Table(name="permisos")
//@IdClass(PermissionId.class)
public class Permission implements Serializable{
    @Id
    @GeneratedValue
    //@MapsId("id_documento")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Documento",nullable = false)
    @PrimaryKeyJoinColumn(name="id_documento", referencedColumnName="id_Documento")
    private Document document;
    
    @Id
    @GeneratedValue
    //@MapsId("id_usuario")
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Usuario",nullable = false)
    @PrimaryKeyJoinColumn(name="id_usuario", referencedColumnName="id_usuario")
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
    
    public Document getDocuemnt() {
        return this.document;
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
