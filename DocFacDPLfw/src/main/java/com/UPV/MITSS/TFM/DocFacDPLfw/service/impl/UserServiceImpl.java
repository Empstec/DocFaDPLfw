/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.service.impl;

import com.UPV.MITSS.TFM.DocFacDPLfw.constants.UserRoles;
import com.UPV.MITSS.TFM.DocFacDPLfw.converter.UserConverter;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.UserRole;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.repository.RoleJpaRepository;
import com.UPV.MITSS.TFM.DocFacDPLfw.repository.UserJpaRepository;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.UserService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author S
 */

@Service("userServiceImpl")
public class UserServiceImpl implements UserService,UserDetailsService{

    @Autowired
    @Qualifier("userJpaRepository")
    private UserJpaRepository userJpaRepository;
    
    @Autowired
    @Qualifier("roleJpaRepository")
    private RoleJpaRepository roleJpaRepository;
    
    @Autowired
    @Qualifier("userConverter")
    private UserConverter converter;
    
    
    @Override
    public List<UserModel> listAllUsers() {
         
        List<com.UPV.MITSS.TFM.DocFacDPLfw.entity.User> userList = userJpaRepository.findAll();
        List<UserModel> userModelList = new ArrayList<UserModel>();
        for(com.UPV.MITSS.TFM.DocFacDPLfw.entity.User u : userList ){
            userModelList.add(converter.convertUserentity2Usermodel(u));
        }
        return userModelList;
    }

    @Override
    public UserModel addUser(UserModel user) {
        com.UPV.MITSS.TFM.DocFacDPLfw.entity.User userEntity = converter.convertUsermodel2Userentity(user);
        UserModel userReturn = converter.convertUserentity2Usermodel(userJpaRepository.save(userEntity)); 
        roleJpaRepository.save(new UserRole(userEntity, UserRoles.ROLE_USER));
        return userReturn; 
    }

    @Override
    public int removeUser(int id_User) {
        userJpaRepository.delete(id_User);
        return 0;
    }

    @Override
    public UserModel updateUser(UserModel user) {
        return converter.convertUserentity2Usermodel(userJpaRepository.save(converter.convertUsermodel2Userentity(user)));
    }

   
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.UPV.MITSS.TFM.DocFacDPLfw.entity.User user = userJpaRepository.findOneByEmail(email);
        return buildUserEntity(user,buildAuthorities(user.getUserRoles()));
    }
    
    private User buildUserEntity(com.UPV.MITSS.TFM.DocFacDPLfw.entity.User user, List<GrantedAuthority> authorities){
        return new User(user.getEmail(), user.getPassword(), true, true, true, true, authorities);
    }
    
    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles){
        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
        
        for(UserRole userRole : userRoles){
            auths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return new ArrayList<GrantedAuthority>(auths);
    }

    @Override
    public boolean existUser(String email) {
        return userJpaRepository.findOneByEmail(email)!= null;
    }

    @Override
    public UserModel getUser(String email) {
        return converter.convertUserentity2Usermodel(userJpaRepository.findOneByEmail(email));
    }
}
