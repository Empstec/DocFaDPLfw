/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Document;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.DocumentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("documentConverter")
public class DocumentConverter {
    
    @Autowired
    @Qualifier("userConverter")
    private UserConverter userConverter;
    
    public DocumentModel convertEntity2Model(Document document){
        DocumentModel documentModel = new DocumentModel();
        documentModel.setAuthor(userConverter.convertEntity2Model(document.getAuthor()));
        documentModel.setId(document.getId_documento());
        documentModel.setTitle(document.getTitle());
        documentModel.setDescription(document.getDescription());
        return documentModel;
    }
    
    public Document convertModel2Entity(DocumentModel document){
        Document documentEntity = new Document();
        documentEntity.setId_documento(document.getId());
        documentEntity.setTitle(document.getTitle());
        documentEntity.setDescription(document.getDescription());
        documentEntity.setAuthor(userConverter.convertModel2Entity(document.getAuthor()));
        return documentEntity;
    }
}
