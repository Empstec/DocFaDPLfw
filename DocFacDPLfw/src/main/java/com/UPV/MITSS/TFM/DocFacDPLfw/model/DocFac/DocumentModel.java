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
    private int id;
    private String title;
    private String descripion;  
    private UserModel author;
    private Map<Integer,Entry<UserModel,PermissionModel>> permissions; // Integer = id_User
    private Map<Integer,FeatureModel> features; // Integer = id_Feature

    public DocumentModel(){
        permissions = new HashMap<>();
        features = new HashMap<>();
    }
    
    public DocumentModel(String title, String descripion, UserModel author, Map<Integer, Entry<UserModel, PermissionModel>> permissions, Map<Integer, FeatureModel> features) {
        this.title = title;
        this.descripion = descripion;
        this.author = author;
        this.permissions = permissions;
        this.features = features;
    }

    public DocumentModel(int id, String title, String descripion, UserModel author, Map<Integer, Entry<UserModel, PermissionModel>> permissions, Map<Integer, FeatureModel> features) {
        this.id = id;
        this.title = title;
        this.descripion = descripion;
        this.author = author;
        this.permissions = permissions;
        this.features = features;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

    public Map<Integer, Entry<UserModel, PermissionModel>> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<Integer, Entry<UserModel, PermissionModel>> permissions) {
        this.permissions = permissions;
    }

    public Map<Integer, FeatureModel> getFeatures() {
        return features;
    }

    public void setFeatures(Map<Integer, FeatureModel> features) {
        this.features = features;
    }
    
    public void setFeature(int id, FeatureModel feature){
        this.features.putIfAbsent(id, feature);
    }
    
    public FeatureModel getFeature(int id){
        return this.features.get(id);
    }
}
