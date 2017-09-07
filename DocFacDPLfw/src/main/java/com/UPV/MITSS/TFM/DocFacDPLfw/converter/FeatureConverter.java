/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Feature;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.FeatureModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("featureConverter")
public class FeatureConverter {
    
    public FeatureModel convertEntity2Model(Feature feature){
        FeatureModel featureModel = new FeatureModel();
        
        return featureModel;
    }
    
    public Feature convertModel2Entity(FeatureModel feature){
        Feature featureEntity = new Feature();
        
        return featureEntity;
    }
            
}
