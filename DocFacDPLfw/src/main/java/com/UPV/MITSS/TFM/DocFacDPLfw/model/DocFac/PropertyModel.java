/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author S
 */

public class PropertyModel {
    /*
    * Diferent type values
    */
    public static final String URL ="URL";
    public static final String TITLE ="TITLE";
    public static final String SUBTITLE ="SUBTITLE";
    public static final String PARAGRAPH ="PARAGRAPH";
    public static final String IMAGE ="IMAGE";
    public static final String VIDEO ="VIDEO";
    public static final String FILE ="URL";
    public static final String AUDIO ="AUDIO";
    public static final String TABLE ="TABLE";
    
    private String name;
    private String type;
    private FeatureModel feature;
    private Map<Integer,ContentModel> contens; // Integer = id_Content
    
}
