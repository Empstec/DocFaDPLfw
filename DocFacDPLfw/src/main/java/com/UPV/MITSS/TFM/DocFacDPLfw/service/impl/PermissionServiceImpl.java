/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.service.impl;

import com.UPV.MITSS.TFM.DocFacDPLfw.converter.PermissionConverter;
import com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac.PermissionModel;
import com.UPV.MITSS.TFM.DocFacDPLfw.repository.PermissionJpaRepository;
import com.UPV.MITSS.TFM.DocFacDPLfw.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Salvador Puertes Aleixandre
 */
@Service("permissionServiceImpl")
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    @Qualifier("permissionJpaRepository")
    private PermissionJpaRepository permissionJpaRepository;
    
    @Autowired
    @Qualifier("permissionConverter")
    private PermissionConverter permissionConverter;
    
    @Override
    public PermissionModel updatePermission(PermissionModel permission) {
        return permissionConverter.convertEntity2Model(permissionJpaRepository.save(permissionConverter.convertModel2Entity(permission)));
    }    
}
