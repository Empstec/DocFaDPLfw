/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Content;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.User;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("userConverter")
public class UserConverter {
    @Autowired
    @Qualifier("contentConverter")
    private ContentConverter contetnConverter;
    
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
        /*for(Content content : user.getContent()){
            userModel.setContent(content.getId_contenido(),contetnConverter.convertEntity2Model(content));
        }*/
        
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
}
