/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.GroupRelation;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.GroupRelationModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("groupRelationConverter")
public class GroupRelationConverter {
    
    public GroupRelationModel convertEntity2Model(GroupRelation group){
        GroupRelationModel groupModel = new GroupRelationModel();
        
        return groupModel;
    }
    
    public GroupRelation convertModel2Entity(GroupRelationModel group){
        GroupRelation groupEntity = new GroupRelation();
        
        return groupEntity;
    }
}
