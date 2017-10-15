/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.repository;

import com.UPV.MITSS.TFM.DocFacDPLfw.entity.Document;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Salvador Puertes Aleixandre
 */
@Repository("documentJpaRepository")
public interface DocumentJpaRepository extends JpaRepository<Document,Serializable>{
}
