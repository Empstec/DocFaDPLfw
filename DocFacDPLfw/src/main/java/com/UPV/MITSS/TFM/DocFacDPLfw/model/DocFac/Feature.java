/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 *
 * @author S
 */

public class Feature {
    
    public static final String MANDATORY = "Mandatory";
    public static final String OPTIONAL = "Optional";
    public static final String FATHER = "Father";
    public static final String CHILD = "Cild";
    public static final String GROUP = "Group";
    
    private boolean root;
    private String name;
    private Map<Integer,Property> properties; // Ingeger = id_Property
    private Map<Integer,Entry<Feature,String>> requirements; // Integer = id_Feature destiny
    private Map<Integer,Entry<Feature,String>> incompatibilities; // Integer = id_Feature destiny2
    private Map<String,Relation> relations; // String = id_Relation+TypeRelactio -> "id;type"
}
