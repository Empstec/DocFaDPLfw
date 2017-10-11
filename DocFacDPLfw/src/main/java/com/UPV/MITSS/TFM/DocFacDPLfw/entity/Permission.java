/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author S
 */
@Entity
@Table(name="permisos")
public class Permission implements Serializable{
    @EmbeddedId
    private PermissionId primarykey;
    
    @MapsId(value="id_documento")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_Documento",nullable = false)
    private Document document;
    
    @MapsId(value="id_usuario")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_Usuario",nullable = false)
    private User user;
    
    @Column(name="permisos")
    private String permissions;
    
    public Permission(){
        this.primarykey = new PermissionId();
    }
    
    public Permission(Document document, User user, String permissions) {
        this.primarykey = new PermissionId(document.getId_documento(),user.getId_usuario());
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

    public PermissionId getPrimarykey() {
        return primarykey;
    }

    public void setPrimarykey(PermissionId primarykey) {
        this.primarykey = primarykey;
    }
    
    
}
