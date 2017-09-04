/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author S
 */

public class FeatureModel {
    
    public static final String MANDATORY = "Mandatory";
    public static final String OPTIONAL = "Optional";
    public static final String FATHER = "Father";
    public static final String CHILD = "Child";
    public static final String GROUP = "Group";
    
    private int id;
    private boolean root;
    private DocumentModel document;
    private String name;
    private FeatureModel prev;
    private FeatureModel post;
    private Map<Integer,PropertyModel> properties; // Ingeger = id_Property
    private Map<Integer,RequirementModel> requirements; // Integer = id_Feature destiny
    private Map<Integer,IncompatibilityModel> incompatibilities; // Integer = id_Feature destiny
    private Map<String,RelationModel> relations; // String = id_Relation+TypeRelactio -> "id;type"
    
    private FeatureModel(){}
    
    public FeatureModel(int id, boolean root,DocumentModel document ,String name, FeatureModel prev, FeatureModel post, Map<Integer, PropertyModel> properties, Map<Integer, RequirementModel> requirements, Map<Integer, IncompatibilityModel> incompatibilities, Map<String, RelationModel> relations) {
        this.id = id;
        this.root = root;
        this.document = document;
        this.name = name;
        this.prev = prev;
        this.post = post;
        this.properties = properties;
        this.requirements = requirements;
        this.incompatibilities = incompatibilities;
        this.relations = relations;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRoot() {
        return this.root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FeatureModel getPrev() {
        return this.prev;
    }

    public void setPrev(FeatureModel prev) {
        this.prev = prev;
    }

    public FeatureModel getPost() {
        return this.post;
    }

    public void setPost(FeatureModel post) {
        this.post = post;
    }

    public DocumentModel getDocument() {
        return document;
    }

    public void setDocument(DocumentModel document) {
        this.document = document;
    }
    
    public Map<Integer, PropertyModel> getProperties() {
        return this.properties;
    }

    public void setProperties(Map<Integer, PropertyModel> properties) {
        this.properties = properties;
    }

    public Map<Integer, RequirementModel> getRequirements() {
        return this.requirements;
    }

    public void setRequirements(Map<Integer, RequirementModel> requirements) {
        this.requirements = requirements;
    }

    public Map<Integer, IncompatibilityModel> getIncompatibilities() {
        return this.incompatibilities;
    }

    public void setIncompatibilities(Map<Integer, IncompatibilityModel> incompatibilities) {
        this.incompatibilities = incompatibilities;
    }

    public Map<String, RelationModel> getRelations() {
        return this.relations;
    }

    public void setRelations(Map<String, RelationModel> relations) {
        this.relations = relations;
    }
    
    public void setRequirement(int id, RequirementModel requirement){
        this.requirements.putIfAbsent(id, requirement);
    }
    
    public RequirementModel getRequirement(int id){
        return this.requirements.get(id);
    }
    
    public void setIncompatibility(int id, IncompatibilityModel incompatibility){
        this.incompatibilities.putIfAbsent(id, incompatibility);
    }
    
    public IncompatibilityModel getIncompatibility(int id){
        return this.incompatibilities.get(id);
    }
    
    public void setProperty(int id, PropertyModel property){
        this.properties.putIfAbsent(id, property);
    }
    
    public PropertyModel getProperty(int id){
        return this.properties.get(id);
    }
    
    public void setDirectRelation(int id, DirectRelationModel directRelation){
        this.relations.putIfAbsent(id+";"+RelationModel.DIRECT,directRelation);
    }
    
    public void setGroupRelation(int id, GroupRelationModel groupRelation){
        this.relations.putIfAbsent(id+";"+RelationModel.GROUP,groupRelation);
    }
    
    public DirectRelationModel getDirectRelation(int id){
        return (DirectRelationModel)this.relations.get(id+";"+RelationModel.DIRECT);
    }
    
    public GroupRelationModel getGroupRelation(int id){
        return (GroupRelationModel)this.relations.get(id+";"+RelationModel.GROUP);
    }
    
    public Map<String,DirectRelationModel> getAllDirectRelation(){
        Iterator it = this.relations.entrySet().iterator();
        Map<String,DirectRelationModel> directRelations = new HashMap<>();
        while(it.hasNext()){
            Map.Entry<String,RelationModel> aux = (Map.Entry<String,RelationModel>)it.next();
            if(aux.getKey().contains(RelationModel.DIRECT))
                directRelations.put(aux.getKey(),(DirectRelationModel)aux.getValue());
        }
        return directRelations;
    }
    
    public Map<String,GroupRelationModel> getAllGroups(){
        Iterator it = this.relations.entrySet().iterator();
        Map<String,GroupRelationModel> groupRelations = new HashMap<>();
        while(it.hasNext()){
            Map.Entry<String,RelationModel> aux = (Map.Entry<String,RelationModel>)it.next();
            if(aux.getKey().contains(RelationModel.GROUP))
                groupRelations.put(aux.getKey(),(GroupRelationModel)aux.getValue());
        }
        return groupRelations;
    }
}
