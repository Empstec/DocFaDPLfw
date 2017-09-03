/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

import java.util.Map;

/**
 *
 * @author S
 */
public class GroupRelationModel extends RelationModel{
    private int id;
    private FeatureModel source;
    private Map<Integer,DirectRelationModel> relations; // Integer = id_Direct_Relacion
    
}
