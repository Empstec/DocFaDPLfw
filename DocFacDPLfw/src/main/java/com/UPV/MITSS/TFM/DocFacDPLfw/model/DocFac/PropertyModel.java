/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author S
 */

public class PropertyModel {
    /*
    * Diferent type values
    */
    public static final String URL ="URL";
    public static final String TITLE ="TITLE";
    public static final String SUBTITLE ="SUBTITLE";
    public static final String PARAGRAPH ="PARAGRAPH";
    public static final String IMAGE ="IMAGE";
    public static final String VIDEO ="VIDEO";
    public static final String FILE ="URL";
    public static final String AUDIO ="AUDIO";
    public static final String TABLE ="TABLE";
    
    private int id;
    private String name;
    private String type;
    private FeatureModel feature;
    private Map<Integer,ContentModel> contens; // Integer = id_Content

    public PropertyModel() {
    }

    public PropertyModel(int id, String name, String type, FeatureModel feature, Map<Integer, ContentModel> contens) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.feature = feature;
        this.contens = contens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FeatureModel getFeature() {
        return feature;
    }

    public void setFeature(FeatureModel feature) {
        this.feature = feature;
    }

    public Map<Integer, ContentModel> getContens() {
        return contens;
    }

    public void setContens(Map<Integer, ContentModel> contens) {
        this.contens = contens;
    }   
}
