/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author S
 */
@Embeddable
class DocumentUserId implements Serializable{
    @ManyToOne
    private Document document;
    @ManyToOne
    private User user;
    
    public DocumentUserId(){}
    
    public void setUser(User user){
        this.user = user;
    }
    
    public User getUser(){
        return this.user;
    }
    
    public void setDocument(Document document){
        this.document = document;
    }
    
    public Document getDocument(){
        return this.document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentUserId that = (DocumentUserId) o;

        if (document != null ? !document.equals(that.document) : that.document != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null)
            return false;

        return true;
    }
    
    @Override
    public int hashCode() {
        int result;
        result = (document != null ? document.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
