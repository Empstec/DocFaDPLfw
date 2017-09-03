/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

/**
 *
 * @author S
 */
// Down to Up
public class DirectRelationModel extends RelationModel{
    private FeatureModel source; // Child
    private FeatureModel destiny; // Father
    private GroupRelationModel group;
  
    public DirectRelationModel(){
        super();
    }
    
    public DirectRelationModel(int id){
        super(id,RelationModel.DIRECT);
    }

    public DirectRelationModel(int id, int mult_Min, int mult_Max) {
        super(id,RelationModel.DIRECT, mult_Min, mult_Max);
    }

    public DirectRelationModel(FeatureModel source, FeatureModel destiny, GroupRelationModel group,int id ,int mult_Min, int mult_Max) {
        super(id,RelationModel.DIRECT, mult_Min, mult_Max);
        this.source = source;
        this.destiny = destiny;
        this.group = group;
    }

    public FeatureModel getSource() {
        return source;
    }

    public void setSource(FeatureModel source) {
        this.source = source;
    }

    public FeatureModel getDestiny() {
        return destiny;
    }

    public void setDestiny(FeatureModel destiny) {
        this.destiny = destiny;
    }

    public GroupRelationModel getGroup() {
        return group;
    }

    public void setGroup(GroupRelationModel group) {
        this.group = group;
    }
}
