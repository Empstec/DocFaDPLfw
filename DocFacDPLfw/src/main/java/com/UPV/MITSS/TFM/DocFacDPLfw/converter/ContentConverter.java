/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Content;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.User;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.ContentModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("contentConverter")
public class ContentConverter {
    // Entity to Model (E2M)
    public ContentModel convertEntity2Model(Content content){
        ContentModel contentModel = new ContentModel();
        
        return contentModel;
    }
    
    // Model to Entity (M2E)
    public Content convertModel2Entity(ContentModel contetn){
        Content contetnEntity = new Content();
        
        return contetnEntity;
    }
    
    // Entity to Model (E2M) with related objects
    public ContentModel fullConvertEntity2Model(Content content, UserModel user){
        ContentModel contentModel = this.convertEntity2Model(content);
        
        return contentModel;
    }
    
    // Model to Entity (M2E) with related objects
    public Content fullConvertModel2Entity(ContentModel contetn, User user){
        Content contetnEntity = this.convertModel2Entity(contetn);
        
        return contetnEntity;
    }
}
