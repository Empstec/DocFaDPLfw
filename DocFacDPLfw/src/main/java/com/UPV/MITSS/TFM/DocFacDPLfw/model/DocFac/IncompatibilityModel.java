/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

/**
 *
 * @author S
 */
public class IncompatibilityModel {
    private FeatureModel feaure;
    private FeatureModel incompatible;
    private String type;

    public IncompatibilityModel() {
    }

    public IncompatibilityModel(FeatureModel feaure, FeatureModel incompatible, String type) {
        this.feaure = feaure;
        this.incompatible = incompatible;
        this.type = type;
    }

    public FeatureModel getFeaure() {
        return feaure;
    }

    public void setFeaure(FeatureModel feaure) {
        this.feaure = feaure;
    }

    public FeatureModel getIncompatible() {
        return incompatible;
    }

    public void setIncompatible(FeatureModel incompatible) {
        this.incompatible = incompatible;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
