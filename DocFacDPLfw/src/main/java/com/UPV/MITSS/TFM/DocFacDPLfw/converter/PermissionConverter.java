/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Document;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Permission;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.PermissionId;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.User;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.DocumentModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.PermissionModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Salvador Puertes Aleixandre
 */
@Component("permissionConverter")
public class PermissionConverter {
    
    @Autowired
    @Qualifier("userConverter")
    private UserConverter userConverter;
    
    @Autowired
    @Qualifier("documentConverter")
    private DocumentConverter documentConverter;
    
    // Entity to Model (E2M)
    public PermissionModel convertEntity2Model(Permission permission){
        PermissionModel permissionModel = new PermissionModel();
        
        permissionModel.setPermissions(permission.getPermissions());
        
        return permissionModel;
    }
    
    // Model to Entity (M2E)
    public Permission convertModel2Entity(PermissionModel permission){
        Permission permissionEntity = new Permission();
        
        permissionEntity.setPermissions(permission.toString());
        
        return permissionEntity;
    }
    
    // Entity to Model (E2M) with related objectr
    public PermissionModel fullConvertEntity2Model(Permission permission, UserModel user){
        PermissionModel permissionModel = this.convertEntity2Model(permission);
        
        permissionModel.setUser(user);
        
        return permissionModel;
    }
    
    // Model to Entity (M2E) with related objects
    public synchronized Permission fullConvertModel2Entity(PermissionModel permission, User user){
        Permission permissionEntity = this.convertModel2Entity(permission);
        
        permissionEntity.setUser(user);
        
        return permissionEntity;
    }
    
    // Model to Entity (M2E) with User and Documnet
    public Permission convertModel2Entity(PermissionModel permission, UserModel user, DocumentModel document){
        Permission permissionEntity = new Permission();
        
        permissionEntity.setDocument(documentConverter.convertModel2Entity(document));
        permissionEntity.setUser(userConverter.convertModel2Entity(user));
        permissionEntity.setPrimarykey(new PermissionId(document.getId(),user.getId()));
        permissionEntity.setPermissions(permission.toString());
        
        return permissionEntity;
    }
    
    // Model to Entity (E2M) with User and Documnet
    public PermissionModel convertEntity2Model(PermissionModel permission, UserModel user, DocumentModel document){
        
        PermissionModel permissionModel = new PermissionModel();
        
        permissionModel.setDoc(document);
        permissionModel.setUser(user);
        permissionModel.setPermissions(permission.toString());
        
        return permissionModel;
    }
}
