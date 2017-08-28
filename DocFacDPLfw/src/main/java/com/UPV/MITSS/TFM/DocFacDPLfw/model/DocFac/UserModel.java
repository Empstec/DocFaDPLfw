/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.model.DocFac;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author S
 */
public class UserModel {
    
    public static final String MALE = "M";
    public static final String FEMALE = "F";
    
    private int id;
    
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Length(min=8,max=50)
    private String password;
    private String company;
    private String department;
    private String role;  
    @Pattern(regexp="^[M|F]{1}$")
    private String sex;
    private String state;
    private String province;
    private String town;
    private String address;
    private String remember;
    private Map<Integer,DocumentModel> documents; // Integer = id_Document
    private Map<Integer,ContentModel> contents; // Integer = id_Content
    private Map<Integer,Entry<DocumentModel,PermissionModel>> permissions; // Integer = id_Document
    
    public UserModel(){}
    
    public UserModel(String name, String surname, String email, String password, String company, String department, String role, String sex, String state, String province, String town, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        this.department = department;
        this.role = role;
        this.sex = sex;
        this.state = state;
        this.province = province;
        this.town = town;
        this.address = address;
    }
    
    public UserModel(int id, String name, String surname, String email, String password, String company, String department, String role, String sex, String state, String province, String town, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        this.department = department;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public String getSex() {
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

    public Map<Integer, DocumentModel> getDocuments() {
        return documents;
    }

    public Map<Integer, ContentModel> getContents() {
        return contents;
    }

    public Map<Integer, Entry<DocumentModel, PermissionModel>> getPermissions() {
        return permissions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getRemember(){
        return remember;
    }
    
    public void setRemember(String remember){
        this.remember = remember;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
}
