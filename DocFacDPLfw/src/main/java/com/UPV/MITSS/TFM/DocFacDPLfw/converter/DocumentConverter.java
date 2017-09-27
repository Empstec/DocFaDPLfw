/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Document;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.User;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.DocumentModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.PermissionModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @Autowired
    @Qualifier("permissionConverter")
    private PermissionConverter permissionConverter;
    
    @Autowired
    @Qualifier("featureConverter")
    private FeatureConverter featureConverter;
    
    // Entity to Model (E2M)
    public DocumentModel convertEntity2Model(Document document){
        DocumentModel documentModel = new DocumentModel();
        
        documentModel.setId(document.getId_documento());
        documentModel.setTitle(document.getTitle());
        documentModel.setDescription(document.getDescription());
        
        return documentModel;
    }
    
    // Model to Entity (M2E)
    public Document convertModel2Entity(DocumentModel document){
        Document documentEntity = new Document();
        
        documentEntity.setId_documento(document.getId());
        documentEntity.setTitle(document.getTitle());
        documentEntity.setDescription(document.getDescription());
        
        return documentEntity;
    }
    
    // Entity to Model (E2M) with related objects
    public DocumentModel fullConvertEntity2Model(Document document, UserModel user){
        DocumentModel documentModel = this.convertEntity2Model(document);
        
        while(user.getPermission(document.getId_documento())==null){}
        
        PermissionModel permission = user.getPermission(document.getId_documento());
        permission.setDoc(documentModel);
        documentModel.setPermission(user.getId(), permission);
        
        return documentModel;
    }
    
    // Model to Entity (M2E) with related objects
    public synchronized Document fullConvertModel2Entity(DocumentModel document, User user){
        Document documentEntity = this.convertModel2Entity(document);
        
        return documentEntity;
    }
}
