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
public class DocumentModel {
    private String title;
    private String descripion;  
    private UserModel author;
    private Map<Integer,Entry<UserModel,PermissionModel>> permissions; // Integer = id_User
    private Map<Integer,FeatureModel> features; // Integer = id_Feature
}
