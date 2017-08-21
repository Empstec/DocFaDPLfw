/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.repository;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.User;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author S
 */
@Repository("userJpaRepository")
public interface UserJpaRepository extends JpaRepository<User,Serializable> {
    
    public abstract User findOneByEmail(String email);
    }
