/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.repository;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.UserRole;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author S
 */
@Repository("roleJpaRepository")
public interface RoleJpaRepository extends JpaRepository<UserRole,Serializable> {
    
}
