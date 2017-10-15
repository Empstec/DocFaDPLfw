/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Content;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Document;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Permission;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.User;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Salvador Puertes Aleixandre
 */
@Component("userConverter")
public class UserConverter {
    @Autowired
    @Qualifier("contentConverter")
    private ContentConverter contentConverter;
    
    @Autowired
    @Qualifier("documentConverter")
    private DocumentConverter documentConverter;
    
    @Autowired
    @Qualifier("permissionConverter")
    private PermissionConverter permissionConverter;
    
    // Entity to Model (M2E)
    public UserModel convertEntity2Model(User user){
        UserModel userModel = new UserModel();
        
        userModel.setId(user.getId_usuario());
        userModel.setName(user.getName());
        userModel.setSurname(user.getSurname());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());
        userModel.setRole(user.getRole());
        userModel.setCompany(user.getCompany());
        userModel.setDepartment(user.getDepartment());
        userModel.setState(user.getState());
        userModel.setProvince(user.getProvince());
        userModel.setTown(user.getTown());
        userModel.setAddress(user.getAddress());
        userModel.setSex(user.getSex());
        
        return userModel;
    }
    
    // Model to Entity (E2M)
    public User convertModel2Entity(UserModel user){
        User userEntity = new User();
        
        userEntity.setId_usuario(user.getId());
        userEntity.setName(user.getName());
        userEntity.setSurname(user.getSurname());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userEntity.setCompany(user.getCompany());
        userEntity.setDepartment(user.getDepartment());
        userEntity.setState(user.getState());
        userEntity.setProvince(user.getProvince());
        userEntity.setTown(user.getTown());
        userEntity.setAddress(user.getAddress());
        userEntity.setSex(user.getSex());
        
        return userEntity;
    }
    
    // Entity to Model (M2E) xith related objects
    public UserModel fullConvertEntity2Model(User user){
        UserModel userModel = this.convertEntity2Model(user);
        
        Thread mainDocumentThread;
        Runnable taskDocuments = () -> {
            user.getDocuments().forEach((Document document) -> {
                userModel.setDocument(document.getId_documento(),documentConverter.fullConvertEntity2Model(document,userModel));
            });
        };
        
        Thread mainContentThread;
        Runnable taskContents = () -> {
            user.getContent().forEach((Content content) -> {
                userModel.setContent(content.getId_contenido(),contentConverter.fullConvertEntity2Model(content,userModel));
            });
        };
        
        Thread mainPermissionThread;
        Runnable taskPermissions = () -> {
            user.getPermissions().forEach((Permission permission) -> {
                userModel.setPermission(permission.getDocuemnt().getId_documento(),permissionConverter.fullConvertEntity2Model(permission,userModel));
            });
        };
        
        mainDocumentThread = new Thread(taskDocuments);
        mainContentThread = new Thread(taskContents);
        mainPermissionThread = new Thread(taskPermissions);
        
        mainPermissionThread.start();
        mainDocumentThread.start();
        mainContentThread.start();
        
        // Blocked
        while(mainContentThread.isAlive() || mainDocumentThread.isAlive() || mainPermissionThread.isAlive()){
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return userModel;
    }
    
    // Model to Entity (E2M) with related objects
    public User fullConvertModel2Entity(UserModel user){
        User userEntity = this.convertModel2Entity(user);
        
        return userEntity;
    }
}
