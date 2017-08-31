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
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author S
 */
@Entity
@Table(name="permisos")
@AssociationOverrides({
    @AssociationOverride(name = "pk.user",joinColumns = @JoinColumn(name = "id_Usuario")),
    @AssociationOverride(name = "pk.docuemnt",joinColumns = @JoinColumn(name = "id_Documento")) })
public class Permission implements Serializable{
    private DocumentUserId pk = new DocumentUserId();
    
    private String permissions;
    
    public Permission(){}

    public void setPermissions(String permissions){
        this.permissions = permissions;
    }
    
    @Column(name="permisos")
    public String getPermissions(){
        return this.permissions;
    }
    
    @EmbeddedId
    public DocumentUserId getPk(){
        return this.pk;
    }
    
    public void setPk(DocumentUserId pk){
        this.pk = pk;
    }
    
    @Transient
    public Document getDocument(){
       return this.getPk().getDocument();
    }
    
    public void setDocuemnt(Document document){
        this.getPk().setDocument(document);
    }
    
    @Transient
    public User getUser(){
        return this.getPk().getUser();
    }
    
    public void setUser(User user){
        this.getPk().setUser(user);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
	if (o == null || getClass() != o.getClass())
            return false;

	Permission that = (Permission) o;

	if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null)
            return false;

	return true;
    }

    @Override
    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
    
}
