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
public class GroupRelation extends Relation{
    private Feature source;
    private Map<Integer,DirectRelation> relations; // Integer = id_Direct_Relacion
    
}
