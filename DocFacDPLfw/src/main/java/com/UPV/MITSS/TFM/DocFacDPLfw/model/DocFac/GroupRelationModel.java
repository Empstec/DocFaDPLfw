/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author S
 */
public class GroupRelationModel extends RelationModel{
    private int id;
    private FeatureModel destiny;
    private Map<String,DirectRelationModel> relations; // String = source;destiny
    
}
