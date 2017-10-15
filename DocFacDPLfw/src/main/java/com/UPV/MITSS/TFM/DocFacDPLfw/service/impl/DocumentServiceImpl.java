/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.service.impl;

import com.UPV.MITSS.TFM.DocFacDPLfw.converter.DocumentConverter;
import com.UPV.MITSS.TFM.DocFacDPLfw.converter.PermissionConverter;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Document;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Permission;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.DocumentModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.repository.DocumentJpaRepository;
import com.UPV.MITSS.TFM.DocFacDPLfw.repository.PermissionJpaRepository;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.DocumentService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Salvador Puertes Aleixandre
 */
@Service("documentServiceImpl")
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private HttpSession httpSession;
    
    @Autowired
    @Qualifier("documentJpaRepository")
    private DocumentJpaRepository documentJpaRepository;
    
    @Autowired
    @Qualifier("permissionJpaRepository")
    private PermissionJpaRepository permissionJpaRepository;
    
    @Autowired
    @Qualifier("documentConverter")
    private DocumentConverter documentConverter;
    
    @Autowired
    @Qualifier("permissionConverter")
    private PermissionConverter permissionConverter;
    
    @Override
    public List<DocumentModel> listAllUserDocuments(UserModel user) {
        // TO-DO
        return null;
    }

    @Override
    public DocumentModel addDocument(DocumentModel document) {
        com.UPV.MITSS.TFM.DocFacDPLfw.entity.Document documentEntity = documentConverter.convertModel2Entity(document);
        UserModel user = (UserModel)httpSession.getAttribute("currentUser");
        DocumentModel documentReturn = documentConverter.convertEntity2Model(documentJpaRepository.save(documentEntity)); 
        
        // Add permission to entity document and return
        documentEntity.setId_documento(documentReturn.getId());
        Permission permission = new Permission(documentEntity, documentEntity.getAuthor(), "RW");
        permissionJpaRepository.save(permission);
        
        // Set Documnet to current user
        user.setDocument(documentReturn.getId(), documentReturn);
        
        //Add PermissionModel to DocumentModel ans UserModel
        documentReturn.setPermission(user.getId(),permissionConverter.convertEntity2Model(permissionConverter.convertEntity2Model(permission),user,documentReturn));
        user.setPermission(documentReturn.getId(), documentReturn.getPermission(user.getId()));
        
        return documentReturn;
    }

    @Override
    public DocumentModel updateDocument(DocumentModel document) {
        return documentConverter.convertEntity2Model(documentJpaRepository.save(documentConverter.convertModel2Entity(document)));
    }    

    @Override
    public Document findDocumentById(int id) {
        return documentJpaRepository.findOne(id);
    }

    @Override
    public void removeDocument(int id) {
        UserModel user = (UserModel)httpSession.getAttribute("currentUser"); 
        DocumentModel document = user.getDocument(id); 
        if(document != null){
            permissionJpaRepository.delete(permissionConverter.convertModel2Entity(user.getPermission(id), user, document));
            documentJpaRepository.delete(documentConverter.convertModel2Entity(document));
            user.deleteDocument(id);
        }
    }
}
