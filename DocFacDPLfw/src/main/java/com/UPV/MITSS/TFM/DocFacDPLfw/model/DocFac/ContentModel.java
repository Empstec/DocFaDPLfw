/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

import java.util.Map;

/**
 *
 * @author S
 */
public class ContentModel {
    private int id;
    private UserModel author;
    private String typeProperty; // Get value from PropertyModel class
    private String content;
    private String type;
    private Map<Integer,PropertyModel> properties; // Integer = id_Property
    
    public ContentModel(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

    public String getTypeProperty() {
        return typeProperty;
    }

    public void setTypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<Integer, PropertyModel> getProperties() {
        return properties;
    }

    public void setProperties(Map<Integer, PropertyModel> properties) {
        this.properties = properties;
    }
    
    public void setProperty(int id, PropertyModel property){
        this.properties.putIfAbsent(id, property);
    }
    
    public PropertyModel getProperty(int id){
        return this.properties.get(id);
    }
}
