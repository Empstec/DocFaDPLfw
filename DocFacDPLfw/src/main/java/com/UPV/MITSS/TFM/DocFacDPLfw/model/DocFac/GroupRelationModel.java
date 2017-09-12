/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author S
 */
public class GroupRelationModel extends RelationModel{
    private FeatureModel destinyGroup;
    private Map<Integer,DirectRelationModel> relations = new HashMap<>(); // Integer = id_Direct_Relation

    public GroupRelationModel() {
        super();
    }
    public GroupRelationModel(int id) {
        super(id,RelationModel.GROUP);
    }

    public GroupRelationModel(int id,int mult_Min, int mult_Max) {
        super(id,RelationModel.GROUP, mult_Min, mult_Max);
    }

    public GroupRelationModel(int id, FeatureModel destinyGroup, Map<Integer, DirectRelationModel> relations, int mult_Min, int mult_Max) {
        super(id,RelationModel.GROUP, mult_Min, mult_Max);
        this.destinyGroup = destinyGroup;
        this.relations = relations;
    }

    public FeatureModel getDestinyGroup() {
        return destinyGroup;
    }

    public void setDestinyGroup(FeatureModel destinyGroup) {
        this.destinyGroup = destinyGroup;
    }

    public Map<Integer, DirectRelationModel> getRelations() {
        return relations;
    }

    public void setRelations(Map<Integer, DirectRelationModel> relations) {
        this.relations = relations;
    }
    
    public void setRelation(int id, DirectRelationModel directRelacion){
        this.relations.putIfAbsent(id, directRelacion);
    }
    
    public DirectRelationModel getDirectRelaction(int id){
        return this.relations.get(id);
    }
}
