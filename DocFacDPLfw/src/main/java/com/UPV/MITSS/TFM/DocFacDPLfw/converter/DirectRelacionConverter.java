/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.DirectRelation;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.DirectRelationModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("directRelationConverter")
public class DirectRelacionConverter {
    public DirectRelationModel convertEntity2Model(DirectRelation direcRelation){
        DirectRelationModel directRelationModel = new DirectRelationModel();
        
        return directRelationModel;
    }
    
    public DirectRelation convertModel2Entity(DirectRelationModel directRelation){
        DirectRelation directRelationEntity = new DirectRelation();
        
        return directRelationEntity;
    }
}
