/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.service.impl;

import com.UPV.MITSS.TFM.DocFacDPLfw.converter.UserConverter;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.User;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.repository.UserJpaRepository;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author S
 */

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("userJpaRepository")
    private UserJpaRepository userJpaRepository;
    
    @Autowired
    @Qualifier("userConverter")
    UserConverter converter;
    
    @Override
    public List<UserModel> listAllUsers() {
        
        
        List<User> userList = userJpaRepository.findAll();
        List<UserModel> userModelList = new ArrayList<UserModel>();
        for(User u : userList ){
            userModelList.add(converter.entity2model(u));
        }
        return userModelList;
    }

    @Override
    public UserModel addUser(UserModel user) {
        return converter.entity2model(userJpaRepository.save(converter.model2entity(user)));
    }

    @Override
    public int removeUser(int id_User) {
        userJpaRepository.delete(id_User);
        return 0;
    }

    @Override
    public UserModel updateUser(UserModel user) {
        return converter.entity2model(userJpaRepository.save(converter.model2entity(user)));
    }
    
}
