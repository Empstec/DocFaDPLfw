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
public class Document {
    private String title;
    private String descripion;  
    private User author;
    private Map<Integer,Entry<User,Permission>> permissions; // Integer = id_User
    private Map<Integer,Feature> features; // Integer = id_Feature
}
