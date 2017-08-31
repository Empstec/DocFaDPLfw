/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UPV.MITSS.TFM.DocFacDPLfw.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Salvador Puertes Aleixandre
 */
@Entity
@Table(name="Usuarios")
public class User {
    @Id
    @GeneratedValue
    @Column(name="id_Usuario",nullable=false,unique=true)
    private int id_usuario;
    
    @Column(name="nombre")
    private String name;
    
    @Column(name="apellidos")
    private String surname;
    
    @Column(name="email",nullable=false,unique=true)
    private String email;
    
    @Column(name="pass",nullable=false)
    private String password;
    
    @Column(name="empresa")
    private String company;
       
    @Column(name="departamento")
    private String department;
    
    @Column(name="rol")
    private String role;
    
    @Column(name="pais")
    private String state;
    
    @Column(name="provincia")
    private String province;

    @Column(name="poblacion")
    private String town;
    
    @Column(name="direccion")
    private String address;

    @Column(name="sexo")
    private String sex;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="user")
    private Set<UserRole> userRoles = new HashSet<UserRole>();
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="user")
    private Set<Content> contents = new HashSet<Content>();
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="pk.user")
    private Set<Permission> permissions = new HashSet<Permission>();
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="user")
    private Set<Document> documents = new HashSet<Document>();
    
    public User(){}

    public User(int id_usuario, String name, String surname, String email, String password, String company, String department, String role, String state, String province, String town, String address, String sex) {
        this.id_usuario = id_usuario;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        this.department = department;
        this.role = role;
        this.state = state;
        this.province = province;
        this.town = town;
        this.address = address;
        this.sex = sex;
    }
    
    public User(int id_usuario, String name, String surname, String email, String password, String company, String department, String role, String state,String province, String town, String address, String sex, Set<UserRole> userRoles, Set<Content> contents, Set<Permission> permissions, Set<Document> documents) {
        this.id_usuario = id_usuario;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        this.department = department;
        this.role = role;
        this.state = state;
        this.province = province;
        this.town = town;
        this.address = address;
        this.sex = sex;
        this.userRoles = userRoles;
        this.contents = contents;
        this.permissions = permissions;
        this.documents = documents;
    }
    
    public User(String name, String surname, String email, String password, String company, String department, String role, String state,String province, String town, String address, String sex, Set<UserRole> userRoles,Set<Content> contents, Set<Permission> permissions, Set<Document> documents) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.company = company;
        this.department = department;
        this.role = role;
        this.state = state;
        this.province = province;
        this.town = town;
        this.address = address;
        this.sex = sex;
        this.userRoles = userRoles;
        this.contents = contents;
        this.permissions = permissions;
        this.documents = documents;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
    
    public Set<Content> getContent() {
        return contents;
    }

    public void setContent(Set<Content> contents) {
        this.contents = contents;
    }
    
    public Set<Permission> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    
    public Set<Document> getDocuments() {
        return this.documents;
    }
    
    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}