/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Content;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.ContentModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("contentConverter")
public class ContentConverter {
    public ContentModel convertEntity2Model(Content content){
        ContentModel contentModel = new ContentModel();
        
        return contentModel;
    }
    
    public Content convertModel2Entity(ContentModel contetn){
        Content contetnEntity = new Content();
        
        return contetnEntity;
    }
}
