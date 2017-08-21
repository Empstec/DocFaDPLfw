/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.service;

import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.UserModel;
import java.util.List;

/**
 *
 * @author S
 */

public interface UserService {
    public abstract List<UserModel> listAllUsers();
    public abstract UserModel addUser(UserModel user);
    public abstract int removeUser(int id_User);
    public abstract boolean existUser(String email);
    public abstract UserModel updateUser(UserModel user);
}
