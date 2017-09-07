/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Requirement;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.RequirementModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("requirementConverter")
public class RequirementConverter {
    public RequirementModel convertEntity2Model(Requirement requirement){
        RequirementModel requiementModel = new RequirementModel();
        
        return requiementModel;
    }
    
    public Requirement convertModel2Entity(RequirementModel requirement){
        Requirement requirementEntity = new Requirement();
        
        return requirementEntity;
    }
}
