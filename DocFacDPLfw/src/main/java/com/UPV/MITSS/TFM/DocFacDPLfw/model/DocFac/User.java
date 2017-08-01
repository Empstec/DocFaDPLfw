/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.validation.constraints.NotNull;

/**
 *
 * @author S
 */
public class User {
    
    public static final String MALE = "M";
    public static final String FEMALE = "F";
    
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String company;
    private String department;
    private String rol;
    private char sex;
    private String state;
    private String province;
    private String town;
    private String address;
    private Map<Integer,Document> documents; // Integer = id_Document
    private Map<Integer,Content> contents; // Integer = id_Content
    private Map<Integer,Entry<Document,Permission>> permissions; // Integer = id_Document

    public User(){}
    
    public User(String name, String surname, String email, String password, String company, String department, String rol, char sex, String state, String province, String town, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        this.department = department;
        this.rol = rol;
        this.sex = sex;
        this.state = state;
        this.province = province;
        this.town = town;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany() {
        return company;
    }

    public String getDepartment() {
        return department;
    }

    public String getRol() {
        return rol;
    }

    public char getSex() {
        return sex;
    }

    public String getState() {
        return state;
    }

    public String getProvince() {
        return province;
    }

    public String getTown() {
        return town;
    }

    public String getAddress() {
        return address;
    }

    public Map<Integer, Document> getDocuments() {
        return documents;
    }

    public Map<Integer, Content> getContents() {
        return contents;
    }

    public Map<Integer, Entry<Document, Permission>> getPermissions() {
        return permissions;
    }
    
}
