/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Property;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.PropertyModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("propertyConverter")
public class PropertyConverter {
    
    public PropertyModel convertEntity2Model(Property property){
        PropertyModel propertyModel = new PropertyModel();
        
        return propertyModel;
    }
    
    public Property convertModel2Entity(PropertyModel property){
        Property propertyEntity = new Property();
        
        return propertyEntity;
    }
}
