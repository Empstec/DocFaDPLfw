/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.converter;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Permission;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.PermissionModel;
import org.springframework.stereotype.Component;

/**
 *
 * @author S
 */
@Component("permissionConverter")
public class PermissionConverter {
    public PermissionModel convertEntity2Model(Permission permission){
        PermissionModel permissionModel = new PermissionModel();
        
        return permissionModel;
    }
    
    public Permission convertModel2Entity(PermissionModel permission){
        Permission permissionEntity = new Permission();
        
        return permissionEntity;
    }
}
