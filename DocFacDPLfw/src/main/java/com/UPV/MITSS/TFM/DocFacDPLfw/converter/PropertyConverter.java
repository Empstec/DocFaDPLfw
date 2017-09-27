/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Property;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.User;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.PropertyModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("propertyConverter")
public class PropertyConverter {
    // Entity to Model (E2M)
    public PropertyModel convertEntity2Model(Property property){
        PropertyModel propertyModel = new PropertyModel();
        
        return propertyModel;
    }

    // Model to Entity (M2E) 
    public Property convertModel2Entity(PropertyModel property){
        Property propertyEntity = new Property();
        
        return propertyEntity;
    }
    
    // Entity to Model (E2M) with related objects
    public PropertyModel fullConvertEntity2Model(Property property, UserModel user){
        PropertyModel propertyModel = this.convertEntity2Model(property);
        
        return propertyModel;
    }
    
    // Model to Entity (M2E) with related objects
    public Property fullConvertModel2Entity(PropertyModel property, User user){
        Property propertyEntity = new Property();
        
        return propertyEntity;
    }
}
