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
public class ContentModel {
    private int id;
    private UserModel author;
    private String typeProperty; // Get value from PropertyModel class
    private String content;
    private String type;
    private Map<Integer,PropertyModel> properties; // Integer = id_Property
}
