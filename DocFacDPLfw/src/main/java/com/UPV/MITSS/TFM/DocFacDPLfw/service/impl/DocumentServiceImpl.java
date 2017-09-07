/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.service.impl;

import com.UPV.MITSS.TFM.DocFacDPLfw.converter.DocumentConverter;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Permission;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.DocumentModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.repository.DocumentJpaRepository;
import com.UPV.MITSS.TFM.DocFacDPLfw.repository.PermissionJpaRepository;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.DocumentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author S
 */
@Service("documentServiceImpl")
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    @Qualifier("documentJpaRepository")
    private DocumentJpaRepository documentJpaRepository;
    
    @Autowired
    @Qualifier("permissionJpaRepository")
    private PermissionJpaRepository permissionJpaRepository;
    
    @Autowired
    @Qualifier("documentConverter")
    private DocumentConverter converter;
    
    @Override
    public List<DocumentModel> listAllUserDocuments(UserModel user) {
        // TO-DO
        return null;
    }

    @Override
    public DocumentModel addDocument(DocumentModel document) {
        com.UPV.MITSS.TFM.DocFacDPLfw.entity.Document documentEntity = converter.convertModel2Entity(document);
        DocumentModel documentReturn = converter.convertEntity2Model(documentJpaRepository.save(documentEntity)); 
        documentEntity.setId_documento(documentReturn.getId());
        permissionJpaRepository.save(new Permission(documentEntity, documentEntity.getAuthor(), "RW"));
        return documentReturn;
    }

    @Override
    public int removeDocument(int id_document) {
        documentJpaRepository.delete(id_document);
        return 0;
    }

    @Override
    public DocumentModel updateDocument(DocumentModel document) {
        return converter.convertEntity2Model(documentJpaRepository.save(converter.convertModel2Entity(document)));
    }
    
}
