/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.service;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Document;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.DocumentModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import java.util.List;

/**
 *
 * @author SHu
 */
public interface DocumentService {
    public abstract List<DocumentModel> listAllUserDocuments(UserModel user);
    public abstract DocumentModel addDocument(DocumentModel document);
    public abstract DocumentModel updateDocument(DocumentModel document);
    public abstract Document findDocumentById(int id);
    public abstract void removeDocument(int id);
}
