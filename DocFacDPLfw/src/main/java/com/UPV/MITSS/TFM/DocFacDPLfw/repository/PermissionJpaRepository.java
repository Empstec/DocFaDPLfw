/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.repository;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Permission;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.User;
import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Document;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author S
 */
@Repository("permissionJpaRepository")
public interface PermissionJpaRepository extends JpaRepository<Permission,Serializable>{
    public abstract Permission findOneByIdDocumentAndIdUser(Document document, User user);
    public abstract Permission findOneByIdDocumentAndIdUser(int document, int user);
    
}
