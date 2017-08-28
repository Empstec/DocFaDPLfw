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
    public UserModel convertUserentity2Usermodel(User user){
        UserModel userModel = new UserModel();
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
        userModel.setId(user.getId_usuario());
        return userModel;
    }
    
    // Model to Entity (E2M)
    public User convertUsermodel2Userentity(UserModel userModel){
        User user = new User();
        user.setName(userModel.getName());
        user.setSurname(userModel.getSurname());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setRole(userModel.getRole());
        user.setCompany(userModel.getCompany());
        user.setDepartment(userModel.getDepartment());
        user.setState(userModel.getState());
        user.setProvince(userModel.getProvince());
        user.setTown(userModel.getTown());
        user.setAddress(userModel.getAddress());
        user.setSex(userModel.getSex());
        user.setId_usuario(userModel.getId());
        return user;
    }
}
