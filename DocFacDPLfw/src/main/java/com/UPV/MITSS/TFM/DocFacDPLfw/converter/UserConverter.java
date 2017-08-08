/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.User;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("userConverter")
public class UserConverter {
    
    // Entity to Model (M2E)
    public UserModel entity2model(User user){
        UserModel userModel = new UserModel();
        userModel.setName(user.getName());
        userModel.setSurname(user.getSurname());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());
        userModel.setRol(user.getRol());
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
    public User model2entity(UserModel userModel){
        User user = new User();
        user.setName(userModel.getName());
        user.setSurname(userModel.getSurname());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setRol(userModel.getRol());
        user.setCompany(userModel.getCompany());
        user.setDepartment(userModel.getDepartment());
        user.setState(userModel.getState());
        user.setProvince(userModel.getProvince());
        user.setTown(userModel.getTown());
        user.setAddress(userModel.getAddress());
        user.setSex(userModel.getSex());
        return user;
    }
}
