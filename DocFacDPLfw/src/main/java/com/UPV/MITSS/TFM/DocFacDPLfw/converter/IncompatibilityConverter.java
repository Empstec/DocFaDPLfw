/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Incompatibility;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.IncompatibilityModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("incompatibilityConverter")
public class IncompatibilityConverter {
    
    public IncompatibilityModel convertEntity2Model(Incompatibility incompatibility){
        IncompatibilityModel incompatibilityModel = new IncompatibilityModel();
        
        return incompatibilityModel;
    }
    
    public Incompatibility convertModel2Entity(IncompatibilityModel incompatibility){
        Incompatibility incompatibilityEntity = new Incompatibility();
        
        return incompatibilityEntity;
    }
}
