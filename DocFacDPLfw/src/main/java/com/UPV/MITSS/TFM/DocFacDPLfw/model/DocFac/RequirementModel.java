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
public class RequirementModel {
    private FeatureModel feature;
    private FeatureModel required;
    private String type;
    
    public RequirementModel(){}

    public RequirementModel(FeatureModel feature, FeatureModel required, String type) {
        this.feature = feature;
        this.required = required;
        this.type = type;
    }

    public FeatureModel getFeature() {
        return feature;
    }

    public void setFeature(FeatureModel feature) {
        this.feature = feature;
    }

    public FeatureModel getRequired() {
        return required;
    }

    public void setRequired(FeatureModel required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
