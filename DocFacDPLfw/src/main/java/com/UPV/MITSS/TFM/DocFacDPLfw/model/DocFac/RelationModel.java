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
public abstract class RelationModel {
    
    public static final String DIRECT = "Direct";
    public static final String GROUP = "Group";
    
    
    private int id;
    private String type;
    private int mult_Min;
    private int mult_Max;
    
    public RelationModel(){}
    
    public RelationModel(int id,String type){
        this.id = id;
        this.type = type;
    }

    public RelationModel(int id,String type, int mult_Min, int mult_Max) {
        this.id = id;
        this.type = type;
        this.mult_Min = mult_Min;
        this.mult_Max = mult_Max;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMult_Min() {
        return mult_Min;
    }

    public void setMult_Min(int mult_Min) {
        this.mult_Min = mult_Min;
    }

    public int getMult_Max() {
        return mult_Max;
    }

    public void setMult_Max(int mult_Max) {
        this.mult_Max = mult_Max;
    }
}
